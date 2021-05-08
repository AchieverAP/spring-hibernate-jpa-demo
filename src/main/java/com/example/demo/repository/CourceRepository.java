package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class CourceRepository {

	@Autowired
	EntityManager em;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteByID(Long id) {
		Course course=findById(id);
		 em.remove(course);
	}
	
	public Course save(Course course) {
		
		if(course.getId()==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
		
	
	}
	
	public void playwithEM() {
	
		logger.info("PLAYING");
		
		Course course1 = new Course("Spring in28minutes");
		em.persist(course1);
		
		Course course2 = new Course("Angular in28minutes");
		em.persist(course2);
		
		em.flush();  //changes which are made untill then will sent out to database 
		course1.setName("Spring in28minutes-updated");// it updates the values in database after persist() called
		course2.setName("Angular in28minutes-updated");
			 
		//em.clear()  //em will not track anything
		
	//	em.detach(course2); //course2 changes will not be saved in Database
		 
		em.refresh(course1);  
		em.flush();
		em.refresh(course2); //get fresh value from database
	}
	
	
	public void timestampdemo() {
 
		logger.info("TIMESTRAMP DEMO.......");
		Course course  = findById(1002L);
	
		course.setName("D+++");
		
	}

	public void addReviewForCourse() {
		// TODO Auto-generated method stub
		
		Course course=findById(1002L);
		logger.info("course review {}",course.getReviews());
		logger.info("course INFOOO {}",course);
		
		Review r1 = new Review("Awesome");
		Review r2 = new Review("Fab");
		
		course.addReviews(r1);
		r1.setCourse(course);
		
		course.addReviews(r2);
		r2.setCourse(course);
		
		em.persist(r1);
		em.persist(r2);
		
	}
	
	//many to many
	public void retriveCourseAndStudentAssociatedwithIt() {
		Course course = findById(1003L);
		logger.info("MY COURSES {}",course);
		logger.info("MY COURSES STUDENT {}",course.getStudents());
		
	}
	
	
}
