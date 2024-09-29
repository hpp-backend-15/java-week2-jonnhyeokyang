package com.hhplus.course.lecture.infra;

import com.hhplus.course.lecture.domain.Lecture;
import com.hhplus.course.lecture.domain.LectureId;
import com.hhplus.course.lecture.domain.LectureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaLectureRepository extends LectureRepository, JpaRepository<Lecture, LectureId> {
    Optional<Lecture> findById(LectureId id);
}
