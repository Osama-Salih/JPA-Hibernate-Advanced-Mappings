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
			findInstructor(appDao);
		};
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
