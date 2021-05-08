package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	public void findStudentAndPassport(Long id) {
		Student student = em.find(Student.class, id);
		logger.info("Student {}",student);
		
		logger.info("passport{}",student.getPassport());
	}
	
	public void deleteByID(Long id) {
		//Student student=findById(id);
		 //em.remove(student);
	}
	
	public Student save(Student student) {
		
		if(student.getId()==null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
		
	
	}
	
	public void saveStudentWithPassport() {
	
		Passport passport = new Passport("Z123456");
		em.persist(passport);
		Student student = new Student("Paresh");
		student.setPassport(passport);
		em.persist(student);
		
	}
	
	
	public void timestampdemo() {
 
		logger.info("TIMESTRAMP DEMO.......");
		//Student student  = findById(1002L);
	
		//student.setName("D+++");
		
	}
	
    
	//many to many
    public void retrieveStudentAndHisCourse() {
           	Student std = em.find(Student.class, 2001L);
           	
           	logger.info("STUDENT {}",std);
        	logger.info("COURSES {}",std.getCourses());
           	
	}
    
    public void insertStudentAndCourse() {
    	Student student = new Student("Shubham");
    	Course course = new Course("Microservices");
    	
    	em.persist(student);
    	em.persist(course);
    	
    	student.addCourse(course);
    	course.addStudent(student);
    	em.persist(student);
    	
    	
    }
    
}
