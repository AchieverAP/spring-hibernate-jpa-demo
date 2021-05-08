package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourceRepository;
import com.example.demo.repository.StudentRepository;



@SpringBootApplication
public class SpringJpaHibernateDemoApplication implements CommandLineRunner {

	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourceRepository courceRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Course course= courceRepository.findById(1001L);
//		logger.info("Course 1001L -> {}",course);
//		
//		//logger.info("Course 1001L delete -> {}",course);
//		//courceRepository.deleteByID(1001L);
//		
//		courceRepository.save(new Course("Spring boot"));
//		
//		//courceRepository.playwithEM();
//		//courceRepository.timestampdemo();
//		
//		studentRepository.saveStudentWithPassport();
//		studentRepository.findStudentAndPassport(2001L);
		
		courceRepository.addReviewForCourse();
		
		studentRepository.retrieveStudentAndHisCourse();
		courceRepository.retriveCourseAndStudentAssociatedwithIt();
		
		studentRepository.insertStudentAndCourse();
		
		
	}

}
