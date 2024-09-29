package com.hhplus.course.lecture.domain;

import com.hhplus.course.user.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureManager {
    private final LectureRepository lectureRepository;

    @Transactional
    public void enroll(LectureId lectureId, UserId userId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(NoSuchElementException::new);
        lecture.join(userId);
    }
}
