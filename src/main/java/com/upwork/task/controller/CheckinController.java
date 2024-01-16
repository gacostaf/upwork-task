package com.upwork.task.controller;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.task.dto.CheckIn;
import com.upwork.task.model.StudentAttendance;
import com.upwork.task.model.StudentCourse;
import com.upwork.task.model.StudentSchedule;
import com.upwork.task.model.StudentTransaction;
import com.upwork.task.service.CourseService;
import com.upwork.task.service.StudentAttendanceService;
import com.upwork.task.service.StudentCourseService;
import com.upwork.task.service.StudentScheduleService;
import com.upwork.task.service.StudentTransactionService;

@RestController
@RequestMapping("/checkin")
public class CheckinController {
	@Value("${studentId}")
	private String studentId;
	@Value("${intervalMinutes}")
	private int intervalMinutes;
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentCourseService studentCourseService;
	@Autowired
	private StudentScheduleService studentScheduleService;
	@Autowired
	private StudentAttendanceService studentAttendanceService;
	@Autowired
	private StudentTransactionService studentTransactionService;
	
	@PostMapping("/course-attendance")
	public ResponseEntity<StudentAttendance> saveCourse(@RequestBody CheckIn checkIn) {
		String transactionId = UUID.randomUUID().toString();
		String courseId = checkIn.getCourseId();
		String hallId = checkIn.getHallId();
		String lectureId = "";
		StudentAttendance studentAttendance = null;
		
		Date startTime = DateUtils.addMinutes(checkIn.getCheckInDate(), intervalMinutes * (-1)); // add minute
		Date endTime   = DateUtils.addMinutes(checkIn.getCheckInDate(), intervalMinutes); // add minute
		
		//Value read from properties due to lack of Front End App
		checkIn.setStudentId(studentId);
		
		//Check if the Student is enrolled in the course
		Collection<StudentCourse> studentCourses = 
				studentCourseService.findAllCoursesByStudent(studentId, checkIn.getCourseId());
//		//The student course we're looking for:
//		StudentCourse sc = studentCourses.stream()
//				.filter(studentCourse -> studentId.equals(studentCourse.getFkIdStudent()))
//				.findAny()
//				.orElse(null);
//		Collection<StudentSchedule> studentClasses = 
//				studentScheduleService.findAllLecturesByStudentCourseHall(studentId, 
//																		  courseId, 
//																		  hallId);
		if (studentCourses != null) {
			//Check the student Schedule to find lectures 
			//based on Course & Hall & Date +/- interval (minutes)
			//Could not be more than one!
			StudentSchedule studentLectureByHall = 
					studentScheduleService
						.findLectureByStudentCourseHall(studentId, 
													   courseId, 
													   hallId,
													   startTime,
													   endTime);
			if (studentLectureByHall != null) {
				//Create transaction ID
				//Transaction record is saved in the datatable
				StudentTransaction st = new StudentTransaction();
				st.setFkIdStudent(studentId);
				st.setIdTransaction(transactionId);
				st.setTransactionDatetime(checkIn.getCheckInDate());
				studentTransactionService.saveStudentTransaction(st);
				// Take the first element
				lectureId = studentLectureByHall.getFkIdLecture();		
			}
			
			//If the transactionId is saved
			//Register Lecture attendance
			StudentTransaction st = studentTransactionService.findStudentTransactionByUUID(transactionId);
			if (st != null) {
				StudentAttendance sa = new StudentAttendance();
				sa.setFkIdStudent(studentId);
				sa.setFkIdCourse(courseId);
				sa.setFkIdHall(hallId);
				sa.setFkIdLecture(lectureId);
				sa.setCheckinDatetime(checkIn.getCheckInDate());
				sa.setIdTransaction(transactionId);
				studentAttendanceService.saveStudentAttendance(sa);
			}
			//Note: Once the studentAttendance record is saved,
			//      we can delete the studentTransaction record.
			//      NOT IMPLEMENTED NOW
			//Fetch record to return
			studentAttendance = studentAttendanceService.findAttendanceByIdTransaction(transactionId);
		}
		if (studentAttendance != null) {
			return new ResponseEntity<>(studentAttendance , HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
