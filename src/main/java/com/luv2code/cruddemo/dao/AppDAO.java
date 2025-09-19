package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    InstructorDetail findInstructorDetail(Integer id);
    void deleteInstructorDetailById(Integer id);
    List<Course> findCoursesByInstructorId(Integer id);
    Instructor findInstructorByIdJoinFetch(Integer id);
    void update(Instructor instructor);
}
