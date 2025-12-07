package com.studentportal;

import com.studentportal.models.*;
import com.studentportal.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private GradeRepo gradeRepo;

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Override
    public void run(String... args) throws Exception {

        //Courses
        Course bsit = Course.builder()
                .id(null)
                .description("Bachelor of Science in Information Technology")
                .courseName("BSIT")
                .build();

        Course bscs = Course.builder()
                .id(null)
                .description("Bachelor of Science in Computer Science")
                .courseName("BSCS")
                .build();
        courseRepo.saveAll(List.of(bsit, bscs));

        //Students
        Student jasper = Student.builder()
                .id(null)
                .contactNumber("09123456789")
                .firstName("Jasper")
                .middleName("Uy")
                .lastName("Cruz")
                .emailAddress("jpcruz@gmail.com")
                .suffix(null)
                .userName("jpcruz")
                .password("12345")
                .year("3rd Year")
                .course(bsit)
                .build();

        Student maria = Student.builder()
                .id(null)
                .contactNumber("09123456789")
                .firstName("Maria")
                .middleName("Tolosa")
                .lastName("Garcia")
                .emailAddress("mtgarcia@gmail.com")
                .suffix(null)
                .userName("mgarcia")
                .password("12345")
                .year("4th Year")
                .course(bscs)
                .build();
        studentRepo.saveAll(List.of(jasper, maria));

        //Subjects
        Subject webDev = Subject.builder()
                .id(null)
                .name("Web Development")
                .description("Frontend and Backend Development")
                .units(3)
                .student(jasper)
                .build();

        Subject db = Subject.builder()
                .id(null)
                .name("Database Systems")
                .description("Relational Databases and SQL")
                .units(3)
                .student(jasper)
                .build();

        Subject algo = Subject.builder()
                .id(null)
                .name("Algorithms")
                .description("Algorithm design and analysis")
                .units(3)
                .student(maria)
                .build();
        subjectRepo.saveAll(List.of(webDev, db, algo));

        //Grades
        Grade g1 = Grade.builder()
                .id(null)
//                .student(jasper)
                .midterms(88.0)
                .finals(92.0)
                .average(90.0)
                .subject(webDev)
                .build();

        Grade g2 = Grade.builder()
                .id(null)
//                .student(jasper)
                .midterms(85.0)
                .finals(87.0)
                .average(86.0)
                .subject(db)
                .build();

        Grade g3 = Grade.builder()
                .id(null)
//                .student(maria)
                .midterms(90.0)
                .finals(89.0)
                .average(89.5)
                .subject(algo)
                .build();

        gradeRepo.saveAll(List.of(g1, g2, g3));

        //Attendance:
        Attendance attendance1 = Attendance.builder()
                .id(null)
                .student(jasper)
                .date(LocalDate.of(2025, 12, 5))
                .status("Present")
                .timeIn(LocalDateTime.of(2025, 12, 5, 8, 0))
                .timeOut(LocalDateTime.of(2025, 12, 5, 16, 0))
                .remarks("On time")
                .build();

        Attendance attendance2 = Attendance.builder()
                .id(null)
                .student(maria)
                .date(LocalDate.of(2025, 12, 5))
                .status("Absent")
                .remarks("Sick leave")
                .build();

        attendanceRepo.saveAll(List.of(attendance1, attendance2));

        //Schedules:
        Schedule schedule1 = Schedule.builder()
                .id(null)
                .student(jasper)
                .course(bsit)
                .instructor("Mr. Reyes")
                .dayOfWeek("Monday")
                .startTime(LocalDateTime.of(2025, 12, 8, 9, 0))
                .endTime(LocalDateTime.of(2025, 12, 8, 11, 0))
                .room("Room 101")
                .term("1st Sem 2025-2026")
                .classSection("A")
                .build();

        Schedule schedule2 = Schedule.builder()
                .id(null)
                .student(maria)
                .course(bscs)
                .instructor("Ms. Santos")
                .dayOfWeek("Tuesday")
                .startTime(LocalDateTime.of(2025, 12, 9, 10, 0))
                .endTime(LocalDateTime.of(2025, 12, 9, 12, 0))
                .room("Room 202")
                .term("1st Sem 2025-2026")
                .classSection("B")
                .build();

        scheduleRepo.saveAll(List.of(schedule1, schedule2));

        //Enrollment:
        Enrollment enrollment1 = Enrollment.builder()
                .id(null)
                .student(jasper)
                .course(bsit)
                .term("1st Sem 2025-2026")
                .enrollmentDate(LocalDate.of(2025, 8, 15))
                .status("ENROLLED")
                .remarks("Regular student")
                .build();

        Enrollment enrollment2 = Enrollment.builder()
                .id(null)
                .student(maria)
                .course(bscs)
                .term("1st Sem 2025-2026")
                .enrollmentDate(LocalDate.of(2025, 8, 15))
                .status("ENROLLED")
                .remarks("Regular student")
                .build();

        enrollmentRepo.saveAll(List.of(enrollment1, enrollment2));

    }

}
