package com.crud.service;

import java.util.List;
import com.crud.model.Salary;

public interface ISalaryService {

	public List<Salary> getAllSalaries();

	public Salary addSalary(Salary salary);

	public Salary getSalById(Long salId);

	public void deleteSalById(Long salId);

	public Salary fetchSalByEmployeeId(Long empId);

}
