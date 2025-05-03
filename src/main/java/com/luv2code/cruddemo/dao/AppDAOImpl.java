package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

        // Define field for entity manager
        private EntityManager entityManager;

        // Inject the entity manager using constructor injection
        @Autowired
        public AppDAOImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        @Override
        @Transactional
        public void save(Instructor instructor) {
            entityManager.persist(instructor);
        }

        @Override
        public Instructor findInstructor(int id) {
                return entityManager.find(Instructor.class, id);
        }

        @Override
        @Transactional
        public void deleteInstructor(int id) {
                Instructor instructor = entityManager.find(Instructor.class, id);

                // Get the instructor's courses
                List<Course> courses = instructor.getCourses();

                for (Course course : courses) {
                    course.setInstructor(null);
                }

                entityManager.remove(instructor);
        }

        @Override
        public InstructorDetail findInstructorDetail(int id) {
                return entityManager.find(InstructorDetail.class, id);
        }

        @Override
        @Transactional
        public void deleteInstructorDetail(int id) {
                InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class ,id);

                instructorDetail.getInstructor().setInstructorDetail(null);
                entityManager.remove(instructorDetail);
        }

        @Override
        public List<Course> findCoursesByInstructorId(int id) {

                TypedQuery<Course> query = entityManager.createQuery(
                                        "from Course where instructor.id = :data", Course.class);

        query.setParameter("data", id);
        return  query.getResultList();
      }

        @Override
        public Instructor findInstructorByIdJoinFetch(int id) {
               TypedQuery<Instructor> query = entityManager.createQuery(
                                           "select i from Instructor i "
                                             + "JOIN FETCH i.courses "
                                             + "JOIN FETCH i.instructorDetail "
                                             + "where i.id = :data", Instructor.class
               );

               query.setParameter("data", id);
               Instructor instructor = query.getSingleResult();
               return instructor;
        }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviews(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = this.entityManager.find(Course.class, id);
        this.entityManager.remove(course);
    }
}
