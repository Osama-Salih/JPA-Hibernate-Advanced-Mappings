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
	CommandLineRunner commandLineRunner(AppDAO appDao) {
		return runner -> {
//			createCourseAndStudent(appDao);
//			findCourseAndStudent(appDao);
//			findStudentAndCourse(appDao);
//			addMoreCoursesForStudent(appDao);
			deleteCourse(appDao);
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDao) {
		int id = 2;
		Student student = appDao.findStudentAndCourseByStudentId(id);

		Course course1 = new Course("Rubik's Cube - How to speed cube");
		Course course2 = new Course("Atari 2600 - Game development");

		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Updating student");
		appDao.update(student);
		System.out.println("Done");
	}

	private void findStudentAndCourse(AppDAO appDao) {

		int id = 1;
		System.out.println("Finding student id - " + id);

		Student student = appDao.findStudentAndCourseByStudentId(id);

		System.out.println("Student: " + student);
		System.out.println("Courses: " + student.getCourses());

		System.out.println("Done");
	}

	private void findCourseAndStudent(AppDAO appDao) {

		int id = 10;
		System.out.println("Finding course id - " + id);
		Course course = appDao.findCourseAndStudentByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("Done");
	}

	private void createCourseAndStudent(AppDAO appDao) {
		Course course = new Course("Pacman - How to score one million points");

		Student student1 = new Student("John", "Doe", "john@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving course: " + course);
		System.out.println("associated students: " + course.getStudents());

		appDao.saveCourse(course);
		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDAO appDao) {
		int id = 10;
		System.out.println("Deleting course id - " + id);

		appDao.deleteCourseById(id);
		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDAO appDao) {
		int id = 10;
		System.out.println("Finding course id - " + id);
		Course course = appDao.findCourseAndReviews(id);

		System.out.println("course: " + course);
		System.out.println("reviews: " + course.getReviews());

		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDao) {

		Course course = new Course("Pacman - How to score one million points");

		course.add(new Review("Greate course ... loved it"));
		course.add(new Review("Cool course, job will done"));
		course.add(new Review("What a dumb course, you are an idiot"));

		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDao.saveCourse(course);

		System.out.println("Done");
	}

	private void deleteCourse(AppDAO appDao) {
		int id = 10;
		System.out.println("Deleting course id - " + id);

		appDao.deleteCourseById(id);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDao) {
		int id = 10;
		System.out.println("Finding course id - " + id);
		Course course = appDao.findCourseById(id);

		System.out.println("Updating course id - " + id);

		course.setTitle("Enjoy the simple things");
		appDao.update(course);

		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDao) {

		int id = 2;
		System.out.println("Finding instructor id - " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Updating instructor id - " + id);

		instructor.setLastName("Osama");
		appDao.update(instructor);

		System.out.println("Done");
	}

	private void findInstructorByJoinFetch(AppDAO appDao) {
		int id = 2;
		System.out.println("Find instructor id - " + id);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDao) {
		int id = 2;
		System.out.println("Find instructor id - " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		System.out.println("Find courses for the instructor");
		List<Course> courses = appDao.findCoursesByInstructorId(id);

		instructor.setCourses(courses);
		System.out.println("The courses: " + instructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDao) {
		int id = 2;
		System.out.println("Finding instructor id - " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDao) {
		Instructor instructor =
				new Instructor("Susan", "Public", "susa@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com",
				"Video Games"
		);

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		appDao.save(instructor);

		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDao) {
		int id = 4;
		System.out.println("Delete instructor detail id - " + id);

		appDao.deleteInstructorDetailById(id);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDao) {
		int id = 2;
		System.out.println("Find instructor detail id - " + id);
		InstructorDetail instructorDetail = appDao.findInstructorDetail(id);

		System.out.println("Instructor detail: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDao) {
		int id = 2;

		System.out.println("Deleted instructor id - " + id);
		appDao.deleteInstructorById(id);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDao) {
		int id = 2;
		System.out.println("Finding instructor id - " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		System.out.println("Instructor detail: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDao) {
//		Instructor instructor =
//				new Instructor("Osama", "Salih", "os@luv2code.com");
//
//		InstructorDetail instructorDetail = new InstructorDetail(
//				"https://www.luv2code.youtube",
//				"luv 2 code"
//		);
//
		Instructor instructor =
				new Instructor("Madhu", "Patel", "madu@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.luv2code.youtube",
				"Guitar"
		);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor");
		appDao.save(instructor);
	}
}
