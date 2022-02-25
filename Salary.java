package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	@Column(name="employee_id")
	private long employeeId;
	
	
	@Column(name="basic_pay")
	private long basicPay;
	
	@Column(name= "month")
	private String month;
	
	@Column(name="salary")
	private long salary;
	
	@Column(name="deductions")
	private long deductions;
	
	@Column(name="net_pay")
	private long netPay;
	
	
	public Salary() {
		
	}


	public Salary(long transactionId, long employeeId,  long basicPay, String month,
			long salary, long deductions, long netPay) {
		super();
		this.transactionId = transactionId;
		this.employeeId = employeeId;
		this.basicPay = basicPay;
		this.month= month;
		this.salary = salary;
		this.deductions = deductions;
		this.netPay = netPay;
	}


	public long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	


	public long getBasicPay() {
		return basicPay;
	}


	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public long getDeductions() {
		return deductions;
	}


	public void setDeductions(long deductions) {
		this.deductions = deductions;
	}


	public long getNetPay() {
		return netPay;
	}


	public void setNetPay(long netPay) {
		this.netPay = netPay;
	}


	

}
