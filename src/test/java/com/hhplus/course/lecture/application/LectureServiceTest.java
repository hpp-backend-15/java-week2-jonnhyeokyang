package com.hhplus.course.lecture.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LectureServiceTest {

    //- 특정 userId 로 선착순으로 제공되는 특강을 신청하는 API 를 작성합니다.
    //- 동일한 신청자는 동일한 강의에 대해서 한 번의 수강 신청만 성공할 수 있습니다.
    //- 특강은 선착순 30명만 신청 가능합니다.
    //- 이미 신청자가 30명이 초과되면 이후 신청자는 요청을 실패합니다.

    /*
        왜 lectureService.join(member) 인가?
        - 현재는 Member 도메인보다 lecture가 더 주요한 도메인이라고 생각했기 때문이다.
        - lectureService (facade) - lectureManager -> join을 위한 도메인 서비스
     */


    @Test
    void 수강신청자id로_수강신청이_가능하다() throws Exception {
        //given
//        Long lectureId = 1L;
//        Long userId = 1L;
//        LectureService lectureService = new LectureService(new LectureRepository(), new MemberManager(), new LectureManager());
//
//        //when
//        lectureService.enroll(lectureId, userId);
//
//        //then
//        lectureService.findBy

    }
}
