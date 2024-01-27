package com.spring.springorm.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.springorm.entities.Student;

import antlr.collections.List;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	//to insert data for student
	public int insert(Student student) {
		
		Integer i=(Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//to fetch single student data
	public Student getStudent(int  studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	//to fetch multiple student data
	public java.util.List<Student> getAllstudents(){
		java.util.List<Student> students =this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	//to delete single  student data
	@Transactional
	public void deleteData(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//to update student data
	@Transactional
	public void updateData(Student student) {
		this.hibernateTemplate.update(student);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
