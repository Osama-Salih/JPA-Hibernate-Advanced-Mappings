package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDao) {
		return runner -> {
//			createInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
//			findInstructorDetail(appDao);
			deleteInstructorDetail(appDao);
		};
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
		int id = 1;

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
