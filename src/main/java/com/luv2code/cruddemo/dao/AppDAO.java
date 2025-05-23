package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructor(int id);

    void deleteInstructor(int id);

    InstructorDetail findInstructorDetail(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    Course findCourseById(int id);

    void update(Course course);

    void save(Course course);

    Course findCourseAndReviews(int id);

    void deleteCourseById(int id);

    Course findCourseAndStudents(int id);

    Student findStudentAndCourses(int id);

    void updateStudentCourses(Student student);

    void deleteStudent(int id);
}
