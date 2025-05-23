package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			updateStudentCourses(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteStudent(id);
		System.out.println("Done");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void updateStudentCourses(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCourses(id);

		Course course1 = new Course("Rubik's Cube - How to Speed Cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("The student: " + student);
		System.out.println("associated courses: " + student.getCourses());

		appDAO.updateStudentCourses(student);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 1;

		Student student = appDAO.findStudentAndCourses(id);

		System.out.println("The student: " + student);
		System.out.println("associated courses: " + student.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndStudents(id);

		System.out.println("The course: " + course);
		System.out.println("associated students: " + course.getStudents());

		System.out.println("Done!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("Pacman - How To Score One Million Points");

		Student student1 = new Student("John", "Doe", "john@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");


		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course: " + course);
		System.out.println("associated students: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 11;

		System.out.println("Deleting course id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void getCourseAndReviews(AppDAO appDAO) {

		int id = 11;
		Course course = appDAO.findCourseAndReviews(id);

		System.out.println("Course: " + course);
		System.out.println("Reviews: " + course.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How to Score One Million Points");

		course.add(new Review("Great course ... loved it!"));
		course.add(new Review("Cool course, job well done."));
		course.add(new Review("What a dumb course, you are an idiot!"));

		System.out.println("The course: " + course);
		System.out.println("The reviews: " + course.getReviews());

		appDAO.save(course);
		System.out.println("done!");
	}

//	private void updateCourse(AppDAO appDAO) {
//		int id = 10;
//
//		// find the Course
//		System.out.println("Finding Course id: " + id);
//		Course course = appDAO.findCourseById(id);
//
//		System.out.println("Updating course id: " + id);
//
//		course.setTitle("Enjoy the simple things");
//		appDAO.update(course);
//
//		System.out.println("Done!");
//	}

//	private void updateInstructor(AppDAO appDAO) {
//
//		int id = 1;
//
////		// find the instructor
//		System.out.println("Finding instructor id: " + id);
//		Instructor instructor = appDAO.findInstructor(id);
//
//		System.out.println("Update instructor data");
//		instructor.setLastName("TESTER");
//
//		appDAO.update(instructor);
//
//		System.out.println("Done!");
//	}

//	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
//		int id = 1;
//
//		// find the instructor
//		System.out.println("Finding instructor id: " + id);
//		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
//
//		System.out.println("Instructor: " + instructor);
//		System.out.println("The associated courses: " + instructor.getCourses());
//
//		System.out.println("Done!");
//	}

//	private void findCoursesForInstructor(AppDAO appDAO) {
//		int id = 1;
//		System.out.println("Finding instructor id: " + id);
//
//		Instructor instructor = appDAO.findInstructor(id);
//
//		System.out.println("Instructor: " + instructor);
//
//		List<Course> courses = appDAO.findCoursesByInstructorId(id);
//
//		instructor.setCourses(courses);
//		System.out.println("The associated courses: " + instructor.getCourses());
//		System.out.println("Done!");
//	}

//	private void findInstructorWithCourses(AppDAO appDAO) {
//		int id = 1;
//		System.out.println("Finding instructor id: " + id);
//
//		Instructor instructor = appDAO.findInstructor(id);
//
//		System.out.println("Instructor: " + instructor);
//		System.out.println("The associated courses: " + instructor.getCourses());
//
//		System.out.println("Done!");
//	}

//	private void createInstructorWithCourses(AppDAO appDAO) {
//		// Create instructor
//		Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
//
//		// Create instructorDetail
//		InstructorDetail instructorDetail = new InstructorDetail("www.luv2code.com/youtube", "Video game");
//
//		instructor.setInstructorDetail(instructorDetail);
//
//		// Create some courses
//		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
//		Course  tempCourse2 = new Course("The Pinball Masterclass");
//
//		// add courses to instructor
//		instructor.add(tempCourse1);
//		instructor.add(tempCourse2);
//
//
//		// save the instructor
//		// Note: this will ALSO save the courses because of CascadeType.PERSIST
//		System.out.println("Saving instructor: " + instructor);
//		System.out.println("Courses: " + instructor.getCourses());
//		appDAO.save(instructor);
//	}

//	private void deleteInstructorDetail(AppDAO appDAO) {
//
//		int instructorDetailId = 3;
//		System.out.println("Deleting instructor detail");
//
//		appDAO.deleteInstructorDetail(instructorDetailId);
//
//		System.out.println("Done!");
//	}

//	private void findInstructorDetail(AppDAO appDAO) {
//
//		int instructorDetailId = 2;
//
//		InstructorDetail instructorDetail = appDAO.findInstructorDetail(instructorDetailId);
//
//		System.out.println("Instructor detail: " + instructorDetail);
//		System.out.println("The associated instructor: " + instructorDetail.getInstructor());
//		System.out.println("Done");
//
//	}

	private void deleteInstructor(AppDAO appDAO) {
		int instructorId = 1;
		System.out.println("Deleting instructor id: " + instructorId);

		appDAO.deleteInstructor(instructorId);

		System.out.println("Done");
	}

//	private void findInstructor(AppDAO appDAO) {
//
//		int instructorId = 2;
//		System.out.println("Finding instructor id: " + instructorId);
//
//		Instructor instructor = appDAO.findInstructor(instructorId);
//
//		System.out.println("instructor: " + instructor);
//		System.out.println("the associated Instructor detail only: " + instructor.getInstructorDetail());
//	}

//	private void createInstructor(AppDAO appDAO) {
////		// Create instructor
////		Instructor instructor = new Instructor("Osama", "Salih", "osama@luv2code.com");
////
////		// Create instructorDetail
////		InstructorDetail instructorDetail = new InstructorDetail("www.luv2code.com/youtupe", "luv 2 code");
////
////
////		instructor.setInstructorDetail(instructorDetail);
//
//		// Create instructor
//		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//
//		// Create instructorDetail
//		InstructorDetail instructorDetail = new InstructorDetail("www.luv2code.com/youtube", "Guitar");
//
//
//		instructor.setInstructorDetail(instructorDetail);
//
//		/*
//		* NOTE: this will ALSO save the details object
//		* */
//		System.out.println("Saving the instructor: " + instructor);
//		appDAO.save(instructor);
////
//		System.out.println("Done");
//	}
}
