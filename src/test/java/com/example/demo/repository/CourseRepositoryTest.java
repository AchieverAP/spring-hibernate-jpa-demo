package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.SpringJpaHibernateDemoApplication;
import com.example.demo.entity.Course;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = SpringJpaHibernateDemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourceRepository courseRepository;

	@Test
	public void findByIDTest() {
		Course course = courseRepository.findById(1001L);
		assertEquals("JAVA", course.getName());
		logger.info("Test running....");
	}

	@Test
	@DirtiesContext
	public void deleteByIDTest() {
		courseRepository.deleteByID(1002L);
		assertNull(courseRepository.findById(1002L));
		logger.info("Test running....2");
	}

	@Test
	@DirtiesContext
	public void save_asic_test() {
		
		//get course
		Course course = courseRepository.findById(1002L);
		assertEquals("C++",course.getName());
		
		//update course
		course.setName("C++ updated");
		
		courseRepository.save(course);
		
		//check the value
		Course course1 = courseRepository.findById(1002L);
		assertEquals("C++ updated",course1.getName());
	}
	
	
	@Test
	public void playwithem() {
		
		
	}
}
