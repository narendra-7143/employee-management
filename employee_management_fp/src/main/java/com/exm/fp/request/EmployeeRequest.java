package com.exm.fp.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.exm.fp.entity.Gender;
import com.exm.fp.enums.StatusType;


public class EmployeeRequest {

	
	@NotEmpty(message = "employee name required")
	@Size(max = 64, message = "employee must be less than or equal to 64 characters")
	private String name;
	
	@NotEmpty(message = "role required")
	private String role;
	
	@NotNull(message = "age required")
	private Integer age;
	
	@NotNull
	private StatusType status;
	
	@NotNull(message = "phone number required")
	@Size(min = 10, max = 10, message= "phone number must be exactly 10 characters")
	private String phoneNumber;
	
	@NotNull(message = "gender required")
	private Gender gender;
	
	@NotNull(message = "salary required")
	private Integer salary;
	
	@NotNull(message = "aadhar required")
	@Size(min = 12, max = 12, message = "Aadhar must be exactly 12 characters")
	private String aadhar;

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	
}
