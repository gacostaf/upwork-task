package com.upwork.task.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upwork.task.model.StudentSchedule;

public interface StudentScheduleRepository extends JpaRepository<StudentSchedule, Integer> {
	@Query(value = "SELECT ss FROM StudentSchedule ss WHERE ss.fkIdStudent = ?1 and ss.fkIdCourse = ?2 and ss.fkIdHall = ?3 and ss.startDatetime between ?4 and ?5", 
		   nativeQuery = false)
    StudentSchedule findLectureByStudentCourseHall(String studentId, 
													String courseId, 
													String hallId,
													Date startDateTime,
													Date endDateTime);

}
