package com.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.model.Salary;
import com.crud.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements ISalaryService {

	
	private SalaryRepository salaryRepository;

	public SalaryServiceImpl(SalaryRepository salaryRepository) {
		super();
		this.salaryRepository = salaryRepository;
	}

	@Override
	public List<Salary> getAllSalaries() {
		return salaryRepository.findAll();
	}

	@Override
	public Salary addSalary(Salary salary) {
		Salary sal = salaryRepository.save(salary);
		return sal;
	}

	@Override
	public Salary getSalById(Long salId) {
		return salaryRepository.findById(salId).get();
	}
	

	@Override
	public void deleteSalById(Long salId) {
		salaryRepository.deleteById(salId);
		
	}

	@Override
	public Salary fetchSalByEmployeeId(Long empId) {
		// TODO Auto-generated method stub
		return salaryRepository.findByEmployeeId(empId);
	}
	
	
}
