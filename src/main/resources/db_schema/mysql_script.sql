use academic;
DROP TABLE IF EXISTS student_program;
DROP TABLE IF EXISTS student_course;
DROP TABLE IF EXISTS student_schedule;  
DROP TABLE IF EXISTS student_attendance;  
DROP TABLE IF EXISTS student_transaction;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS lecture;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS program;
DROP TABLE IF EXISTS hall;

CREATE TABLE `academic`.`student` (
  `pk_student` INT AUTO_INCREMENT NOT NULL,
  `id_student` CHAR(7) UNIQUE NOT NULL COMMENT 'Unique Reference Number URN (7 digits)',
  `country` CHAR(3) NOT NULL COMMENT 'ISO Country Code',
  `phone` CHAR(10) NOT NULL COMMENT 'Local phone number (area+ phone number) ',
  `full_name` VARCHAR(100) NOT NULL COMMENT 'Real world implementation should separate into given_name + middle_name + family_name',
  PRIMARY KEY (`pk_student`));

INSERT INTO `academic`.`student` (`id_student`, `country`, `phone`, `full_name`) VALUES ('1234567', '52', '5515260442', 'Gerardo Acosta');
INSERT INTO `academic`.`student` (`id_student`, `country`, `phone`, `full_name`) VALUES ('1234568', '52', '5555688722', 'John Doe');

CREATE TABLE `program` (
  `pk_program` int NOT NULL AUTO_INCREMENT,
  `id_program` varchar(45) UNIQUE NOT NULL,
  `name` varchar(100) UNIQUE NOT NULL,
  PRIMARY KEY (`pk_program`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`program` (`id_program`, `name`) VALUES ('CE-BS', 'Computer Engineering B.S.');
INSERT INTO `academic`.`program` (`id_program`, `name`) VALUES ('EE-BS', 'Electrical Engineering B.S.');

CREATE TABLE `course` (
  `pk_course` int NOT NULL AUTO_INCREMENT,
  `fk_id_program` varchar(45) NOT NULL,
  `id_course` varchar(45) UNIQUE NOT NULL,
  `name` varchar(100) UNIQUE NOT NULL,
  PRIMARY KEY (`pk_course`),
  KEY `fk_course_program_idx` (`fk_id_program`),
  CONSTRAINT `fk_course_program` FOREIGN KEY (`fk_id_program`) REFERENCES `program` (`id_program`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`course` (`fk_id_program`, `id_course`, `name`) VALUES ('CE-BS', '111', 'Computer Science 111, fall 2022. Operating Systems Principles');
INSERT INTO `academic`.`course` (`fk_id_program`, `id_course`, `name`) VALUES ('CE-BS', '35L', 'Computer Science 35L, fall 2022. Software Construction');

CREATE TABLE `hall` (
  `pk_hall` int NOT NULL AUTO_INCREMENT,
  `id_hall` varchar(45) UNIQUE NOT NULL,
  `name` varchar(100) UNIQUE NOT NULL,
  PRIMARY KEY (`pk_hall`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`hall` (`id_hall`, `name`) VALUES ('CB-301', 'Charles Babbage Building - Hall 301');
INSERT INTO `academic`.`hall` (`id_hall`, `name`) VALUES ('CB-302', 'Charles Babbage Building - Hall 302');
INSERT INTO `academic`.`hall` (`id_hall`, `name`) VALUES ('CB-303', 'Charles Babbage Building - Hall 303');
INSERT INTO `academic`.`hall` (`id_hall`, `name`) VALUES ('CB-304', 'Charles Babbage Building - Hall 304');
INSERT INTO `academic`.`hall` (`id_hall`, `name`) VALUES ('CB-305', 'Charles Babbage Building - Hall 305');

CREATE TABLE `lecture` (
  `pk_lecture` int NOT NULL AUTO_INCREMENT,
  `id_lecture` varchar(45) UNIQUE NOT NULL,
  `fk_id_course` varchar(45) NOT NULL,
  `hall` varchar(45) NOT NULL,
  `start_datetime` datetime NOT NULL,
  `end_datetime` datetime NOT NULL,
  `instructor` varchar(100) NOT NULL,
  PRIMARY KEY (`pk_lecture`),
  KEY `fk_lecture_course_idx` (`fk_id_course`),
  CONSTRAINT `fk_lecture_course` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-01', '111', 'CB-301', '2024-01-15 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-02', '111', 'CB-302', '2024-01-17 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-03', '111', 'CB-303', '2024-01-19 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-04', '111', 'CB-304', '2024-01-22 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-05', '111', 'CB-305', '2024-01-24 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-06', '111', 'CB-304', '2024-01-26 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-07', '111', 'CB-303', '2024-01-29 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-08', '111', 'CB-302', '2024-01-31 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');
INSERT INTO `academic`.`lecture` (`id_lecture`, `fk_id_course`, `hall`, `start_datetime`, `end_datetime`,  `instructor`) VALUES ('111-09', '111', 'CB-301', '2024-02-02 10:00:00', '2024-01-15 12:00:00', 'Linus Torvalds');

CREATE TABLE `student_program` (
  `pk_student_program` int NOT NULL AUTO_INCREMENT,
  `fk_id_student` varchar(7) NOT NULL,
  `fk_id_program` varchar(45) NOT NULL,
  `enrollment_datetime` datetime NOT NULL,
  PRIMARY KEY (`pk_student_program`),
  KEY `fk_student_program_student_idx` (`fk_id_student`),
  CONSTRAINT `fk_student_program_student` FOREIGN KEY (`fk_id_student`) REFERENCES `student` (`id_student`),
  KEY `fk_student_program_program_idx` (`fk_id_program`),
  CONSTRAINT `fk_student_program_program` FOREIGN KEY (`fk_id_program`) REFERENCES `program` (`id_program`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`student_program` (`fk_id_student`, `fk_id_program`, `enrollment_datetime`) VALUES ('1234567', 'CE-BS', '2024-01-01T00:00:00');

CREATE TABLE `student_course` (
  `pk_student_course` int NOT NULL AUTO_INCREMENT,
  `fk_id_student` varchar(7) NOT NULL,
  `fk_id_course` varchar(45) NOT NULL,
  `enrollment_datetime` datetime NOT NULL,
  PRIMARY KEY (`pk_student_course`),
  KEY `fk_student_course_student_idx` (`fk_id_student`),
  CONSTRAINT `fk_student_course_student` FOREIGN KEY (`fk_id_student`) REFERENCES `student` (`id_student`),
  KEY `fk_student_course_course_idx` (`fk_id_course`),
  CONSTRAINT `fk_student_course_course` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`student_course` (`fk_id_student`, `fk_id_course`, `enrollment_datetime`) VALUES ('1234567', '111', '2024-01-01T00:00:00');

CREATE TABLE `student_schedule` (
  `pk_student_schedule` int NOT NULL AUTO_INCREMENT,
  `fk_id_student` varchar(7) NOT NULL,
  `fk_id_course` varchar(45) NOT NULL,
  `fk_id_hall` varchar(45) NOT NULL,
  `fk_id_lecture` varchar(45) NOT NULL,
  `start_datetime` datetime NOT NULL,
  `end_datetime` datetime NOT NULL,
  PRIMARY KEY (`pk_student_schedule`),
  KEY `fk_student_schedule_student_idx` (`fk_id_student`),
  CONSTRAINT `fk_student_schedule_student` FOREIGN KEY (`fk_id_student`) REFERENCES `student` (`id_student`),
  KEY `fk_student_schedule_course_idx` (`fk_id_course`),
  CONSTRAINT `fk_student_schedule_course` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`),
  KEY `fk_student_schedule_hall_idx` (`fk_id_hall`),
  CONSTRAINT `fk_student_schedule_hall` FOREIGN KEY (`fk_id_hall`) REFERENCES `hall` (`id_hall`),
  KEY `fk_student_schedule_lecture_idx` (`fk_id_lecture`),
  CONSTRAINT `fk_student_schedule_lecture` FOREIGN KEY (`fk_id_lecture`) REFERENCES `lecture` (`id_lecture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-01', '2024-01-15 10:00:00', '2024-01-15 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-02', '2024-01-17 10:00:00', '2024-01-17 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-03', '2024-01-19 10:00:00', '2024-01-19 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-04', '2024-01-22 10:00:00', '2024-01-22 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-05', '2024-01-24 10:00:00', '2024-01-24 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-06', '2024-01-26 10:00:00', '2024-01-26 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-07', '2024-01-29 10:00:00', '2024-01-29 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-08', '2024-01-31 10:00:00', '2024-01-31 12:00:00');
INSERT INTO `academic`.`student_schedule` (`fk_id_student`, `fk_id_course`, `fk_id_hall`, `fk_id_lecture`, `start_datetime`, `end_datetime`) VALUES ('1234567', '111', 'CB-301', '111-09', '2024-02-02 10:00:00', '2024-02-02 12:00:00');

CREATE TABLE `student_attendance` (
  `pk_student_attendance` int NOT NULL AUTO_INCREMENT,
  `fk_id_student` varchar(7) NOT NULL,
  `fk_id_course` varchar(45) NOT NULL,
  `fk_id_hall` varchar(45) NOT NULL,
  `fk_id_lecture` varchar(45) NOT NULL,
  `checkin_datetime` datetime NOT NULL,  
  `id_transaction` char(36) NOT NULL DEFAULT (UUID()),
  PRIMARY KEY (`pk_student_attendance`),
  KEY `fk_student_attendance_student_idx` (`fk_id_student`),
  CONSTRAINT `fk_student_attendance_student` FOREIGN KEY (`fk_id_student`) REFERENCES `student` (`id_student`),
  KEY `fk_student_attendance_course_idx` (`fk_id_course`),
  CONSTRAINT `fk_student_attendance_course` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`),
  KEY `fk_student_attendance_hall_idx` (`fk_id_hall`),
  CONSTRAINT `fk_student_attendance_hall` FOREIGN KEY (`fk_id_hall`) REFERENCES `hall` (`id_hall`),
  KEY `fk_student_attendance_lecture_idx` (`fk_id_lecture`),
  CONSTRAINT `fk_student_attendance_lecture` FOREIGN KEY (`fk_id_lecture`) REFERENCES `lecture` (`id_lecture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student_transaction` (
  `pk_student_transaction` int NOT NULL AUTO_INCREMENT,
  `id_transaction` char(36) NOT NULL DEFAULT (UUID()),
  `fk_id_student` varchar(7) NOT NULL,
  `transaction_datetime` datetime NOT NULL DEFAULT (NOW()),  
  PRIMARY KEY (`pk_student_transaction`),
  KEY `fk_student_transaction_student_idx` (`fk_id_student`),
  CONSTRAINT `fk_student_transaction_student` FOREIGN KEY (`fk_id_student`) REFERENCES `student` (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `academic`.`student_transaction` (`fk_id_student`) VALUES ('1234567');


  