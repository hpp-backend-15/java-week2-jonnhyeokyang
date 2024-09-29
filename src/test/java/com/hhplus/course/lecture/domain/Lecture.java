package com.hhplus.course.lecture.domain;

import com.hhplus.course.user.UserId;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Builder
public class Lecture {
    @EmbeddedId
    private LectureId id;

    private LocalDate lecturingDate;

    @Getter
    @ElementCollection
    private final List<UserId> studentIds = new ArrayList<>();

    public static Lecture from(LocalDate lecturingDate) {
        return Lecture.builder()
                .lecturingDate(lecturingDate)
                .build();
    }

    public void join(UserId userId) {
        if (LocalDate.now().isAfter(lecturingDate)) {
            throw new IllegalStateException("이미 종료된 강좌를 수강할 수 없습니다.");
        }
        if (studentIds.size() >= 30) {
            throw new IllegalStateException("30명의 수강생 이상이 신청했습니다.");
        }
        if (studentIds.contains(userId)) {
            throw new IllegalStateException("중복 강좌를 수강할 수 없습니다.");
        }
        studentIds.add(userId);
    }

    public boolean hasUserOf(UserId userId) {
        return studentIds.contains(userId);
    }
}
