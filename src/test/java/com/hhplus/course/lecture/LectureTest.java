package com.hhplus.course.lecture;

import com.hhplus.course.user.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.lang.Integer.toUnsignedLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LectureTest {

    Lecture lecture;

    @BeforeEach
    void setUp() {
        lecture = new Lecture(LectureId.of("1"), LocalDate.now().plusMonths(1));
    }


    @Test
    void 강의를_수강할수_있어야한다() throws Exception {
        //given
        UserId userId = new UserId(1L);

        //when
        lecture.join(userId);

        //then
        assertThat(lecture.getStudentIds()).isNotEmpty();
    }

    @Test
    void 강의의_수강생이30명이상이라면_수강실패한다() throws Exception {
        //given
        for (int i = 0; i < 30; i++) {
            UserId userId = new UserId(toUnsignedLong(i));
            lecture.join(userId);
        }

        //when
        //then
        assertThatThrownBy(() -> lecture.join(new UserId(31L)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("30명의 수강생 이상이 신청했습니다.");

    }

    @Test
    void 강의의_수강생이중복됐다면_수강실패한다() throws Exception {
        //given
        UserId userId = new UserId(1L);

        //when
        lecture.join(userId);

        //then
        assertThatThrownBy(() -> lecture.join(userId))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("중복 강좌를 수강할 수 없습니다.");

    }

    @Test
    void 수강시점이_강좌일을지났다면_수강실패한다() throws Exception {
        //given
        lecture = Lecture.from(LocalDate.now().minusDays(1));
        UserId userId = new UserId(1L);

        //when

        //then
        assertThatThrownBy(() -> lecture.join(userId))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("이미 종료된 강좌를 수강할 수 없습니다.");

    }

    @Test
    void 유저가수강신청했다면_신청여부는_참이다() throws Exception {
        //given
        UserId userId = new UserId(1L);

        //when
        lecture.join(userId);
        boolean hasUser = lecture.hasUserOf(userId);

        //then
        assertThat(hasUser).isTrue();

    }

    @Test
    void 유저가수강신청하지않았다면_신청여부는_거짓이다() throws Exception {
        //given
        UserId userId = new UserId(1L);

        //when
        boolean hasUser = lecture.hasUserOf(userId);

        //then
        assertThat(hasUser).isFalse();

    }
}