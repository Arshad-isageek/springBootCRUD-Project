package com.arshadvasg.springBootCRUDProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshadvasg.springBootCRUDProject.entity.Student;

public interface StudentDAO extends JpaRepository<Student,Integer>{

	
}
