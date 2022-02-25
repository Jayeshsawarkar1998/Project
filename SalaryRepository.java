package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {

	public Salary findByEmployeeId(Long empId);

}
