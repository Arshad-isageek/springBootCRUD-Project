package com.arshadvasg.springBootCRUDProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshadvasg.springBootCRUDProject.dao.StudentDAO;
import com.arshadvasg.springBootCRUDProject.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO dao;
	
	public String addStudent(Student student) {
		dao.save(student);
		return "New Student has been added into Database, roll_id number :"+student.getRoll_id();
	}
	
	public String addStudents(List<Student> students) {
		dao.saveAll(students);
		return "All new Student has been added into Database";
	}
	
	public String deleteStudent(int roll_id) {
		Student student = dao.getById(roll_id);
		dao.delete(student);
		return "roll_id Number is deleted :"+roll_id;
	}
	
	public String updateStudent(Student student) {
		dao.save(student);
		return "roll_id Number is update :"+student.getRoll_id();
	}
	
	public Student getStudent(int roll_id) {
		return dao.findById(roll_id).get();
	}
	
}
