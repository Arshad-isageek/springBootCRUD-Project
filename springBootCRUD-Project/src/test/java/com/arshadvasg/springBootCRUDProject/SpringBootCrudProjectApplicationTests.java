package com.arshadvasg.springBootCRUDProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arshadvasg.springBootCRUDProject.dao.StudentDAO;
import com.arshadvasg.springBootCRUDProject.entity.Student;

@SpringBootTest
@TestClassOrder(OrderAnnotation.class)
class SpringBootCrudProjectApplicationTests {

	@Autowired
	StudentDAO sdao; 
	
	@Test
	@Order(1)
	void testCreate() {
	
		Student sTest = new Student();
		sTest.setRoll_id(313);
		sTest.setName("Mohammed Arshad");
		sTest.setAddress("32nd Street, Plano, TX");
		sTest.setGraduated("Yes");
		sdao.save(sTest);
		assertNotNull(sdao.findById(313).get());
		
	}
	
	@Test
	@Order(2)
	void testToReadAll() {
		List<Student> sList = sdao.findAll();
		assertThat(sList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	void testGraduated() {
		Student sTestGrad = sdao.findById(313).get();
		assertEquals("Yes", sTestGrad.getGraduated());
	}

	@Test
	@Order(4)
	void testUpdateInfo() {
		Student si = sdao.findById(400).get();
		si.setName("Asma Binth Sulaima");
		sdao.save(si);
		assertNotEquals("Shazil Mohammed", sdao.findById(400).get().getName());
	}

	@Test
	@Order(5)
	void testDeleteinfo() {
		// Student sde = sdao.findById(193).get();
		// sdao.delete(sde);
		sdao.deleteById(201);
		assertFalse(sdao.existsById(201));
	}

}
