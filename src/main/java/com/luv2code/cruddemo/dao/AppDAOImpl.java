package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
                entityManager.remove(instructorDetail);
        }
}
