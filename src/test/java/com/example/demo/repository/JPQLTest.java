package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void playwithem() {

		List resultlist = em.createQuery("Select c from Course c").getResultList();
		logger.info("Quesry result {}", resultlist);
	}

	@Test
	public void playwithem_asic() {

		TypedQuery<Course> result = em.createQuery("Select c from Course c", Course.class);
		logger.info("Quesry result {}", result.getResultList());
	}
}
