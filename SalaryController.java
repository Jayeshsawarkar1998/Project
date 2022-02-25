package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.model.Salary;
import com.crud.service.ISalaryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SalaryController {
	
	@Autowired
	private ISalaryService salaryService;

	public SalaryController(ISalaryService salaryService) {
		super();
		this.salaryService = salaryService;
	}
	
	@GetMapping("/salaries")
	public ResponseEntity<List<Salary>>getAllEmployees(){
		List<Salary> sal = salaryService.getAllSalaries();
		return new ResponseEntity<List<Salary>>(sal,HttpStatus.OK);
	}
	
	@PostMapping("/salaries")
	public ResponseEntity<Salary> addSalary(@RequestBody Salary salary){
		Salary sal =salaryService.addSalary(salary);
		return new ResponseEntity<Salary>(sal,HttpStatus.CREATED);
	}
	
	@GetMapping("/salaries/{eId}")
	public ResponseEntity<Salary> getSalaryByEmployeeId(@PathVariable("eId") Long empId){
		Salary salRetrieved = salaryService.fetchSalByEmployeeId(empId);
		return new ResponseEntity<Salary>(salRetrieved,HttpStatus.OK);
	}
	
	@GetMapping("/salariesid/{id}")
	public ResponseEntity<Salary> getSalaryByTransactionId(@PathVariable("id") Long empId){
		Salary salRetrieved = salaryService.getSalById(empId);
		return new ResponseEntity<Salary>(salRetrieved,HttpStatus.OK);
	}
	
	@DeleteMapping("/salaries/{id}")
	public ResponseEntity<Void> deleteSalById(@PathVariable("id") Long salId){
		salaryService.deleteSalById(salId);
		return new ResponseEntity<Void>( HttpStatus.ACCEPTED);
	}
	
	// update employee rest api	
	@PutMapping("/salaries/{id}")
	public ResponseEntity<Salary> updateSalarybyId(@PathVariable Long id, @RequestBody Salary salary){
		Salary sal = salaryService.getSalById(id);
		
		sal.setBasicPay(salary.getBasicPay());
		sal.setDeductions(salary.getDeductions());
		sal.setMonth(salary.getMonth());
		sal.setNetPay(salary.getNetPay());
		sal.setSalary(salary.getSalary());
		
		Salary updatedSalary = salaryService.addSalary(sal);
		return ResponseEntity.ok(updatedSalary);
	}

}
