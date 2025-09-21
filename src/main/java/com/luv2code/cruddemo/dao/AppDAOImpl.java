package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {
        Instructor instructor = this.entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();

        for (Course course : courses) {
            course.setInstructor(null);
        }
        this.entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetail(Integer id) {
        return this.entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(Integer id) {
        InstructorDetail instructorDetail = this.entityManager.find(InstructorDetail.class, id);

//        remove the associated object reference
//        break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        this.entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {
        TypedQuery<Course> query = this.entityManager.createQuery(
                "from Course where instructor.id =:data", Course.class
        );
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {
        TypedQuery<Instructor> query = this.entityManager.createQuery(
                    "select i from Instructor i "
                             + "JOIN FETCH i.courses "
                             + "JOIN FETCH i.instructorDetail "
                             + "where i.id =: data ", Instructor.class);

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        this.entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(Integer id) {
        return this.entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        this.entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(Integer id) {
        Course course = this.entityManager.find(Course.class, id);
        this.entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviews(Integer id) {
        TypedQuery<Course> query = this.entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id =: data ", Course.class
        );

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentByCourseId(Integer id) {
        TypedQuery<Course> query = this.entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id =: data ", Course.class
        );

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCourseByStudentId(Integer id) {
        TypedQuery<Student> query = this.entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id =: data ", Student.class
        );

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }
}
