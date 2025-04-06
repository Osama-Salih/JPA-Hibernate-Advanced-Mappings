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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int instructorDetailId = 2;
		System.out.println("Deleting instructor detail");

		appDAO.deleteInstructorDetail(instructorDetailId);

		System.out.println("Done!");
	}

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

//	private void deleteInstructor(AppDAO appDAO) {
//		int instructorId = 1;
//		System.out.println("Deleting instructor id: " + instructorId);
//
//		appDAO.deleteInstructor(instructorId);
//
//		System.out.println("Done");
//	}

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
//
//		System.out.println("Done");
//	}
}
