package com.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.crud.model.Salary;
import com.crud.repository.SalaryRepository;
import static org.assertj.core.api.Assertions.assertThat;




@SpringBootTest
@TestMethodOrder( OrderAnnotation.class)
class SpringbootBackendApplicationTests {
@Autowired
SalaryRepository srepo;

@Test
@Order(1)
	public void SalaryCreate () {
		Salary sal=new Salary();
		sal.setTransactionId(4);
		sal.setEmployeeId(2001);
		sal.setBasicPay(10000);
		sal.setMonth("january");
		sal.setSalary(20000);
		sal.setDeductions(5000);
		sal.setNetPay(15000);
		
		srepo.save(sal);
		assertNotNull((srepo.findById(4L).get()));
	}
@Test
@Order(2)
public void SalaryReadAll() {
	List<Salary>list=srepo.findAll();
	assertThat(list).size().isGreaterThan(0);	
}
@Test
@Order(3)
public void SalaryRead() {
	Salary s=srepo.findById(4L).get();
	assertEquals(2001,s.getEmployeeId());
}
@Test
@Order(4)
public void SalaryUpdate() {
	Salary s =srepo.findById(4L).get();
	s.setMonth("feb");
	srepo.save(s);
	assertNotEquals("january", srepo.findById(4L).get().getMonth());
}
@Test
@Order(5)
public void SalaryDelete () {
	srepo.deleteById(4L);
	assertThat(srepo.existsById(4L)).isFalse();
}
}


