package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE",
	joinColumns = @JoinColumn(name = "STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name ="COURSE_ID"))
	private List<Course> courses = new ArrayList<Course>();
	
	protected Student() {

	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
		
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}