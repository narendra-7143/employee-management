package com.exm.fp.map.request;

import java.time.Instant;
import java.util.UUID;
import org.springframework.stereotype.Component;

import com.exm.fp.entity.Employee;
import com.exm.fp.enums.StatusType;
import com.exm.fp.request.EmployeeRequest;


@Component
public class EmployeeRequestMap {

	public Employee createRequestMap(EmployeeRequest employeeRequest) {
		
		Employee employeeDetails = new Employee();
		employeeDetails.setId(UUID.randomUUID().toString());
		employeeDetails.setCreatedTime(Instant.now());
		employeeDetails.setStatus(StatusType.ACTIVE);
		employeeDetails.setUpdatedTime(Instant.now());
		employeeDetails.setGender(employeeRequest.getGender());
		employeeDetails.setName(employeeRequest.getName());
		employeeDetails.setAge(employeeRequest.getAge());
		employeeDetails.setPhoneNumber(employeeRequest.getPhoneNumber());
		employeeDetails.setRole(employeeRequest.getRole());
		employeeDetails.setSalary(employeeRequest.getSalary());
		employeeDetails.setAadhar(employeeRequest.getAadhar());
		
		return employeeDetails;
	}
	
	public Employee updateRequestMap(Employee employeeDetails ,EmployeeRequest employeeRequest) {
		
		employeeDetails.setStatus(employeeRequest.getStatus());
		employeeDetails.setUpdatedTime(Instant.now());
		employeeDetails.setGender(employeeRequest.getGender());
		employeeDetails.setName(employeeRequest.getName());
		employeeDetails.setAge(employeeRequest.getAge());
		employeeDetails.setPhoneNumber(employeeRequest.getPhoneNumber());
		employeeDetails.setRole(employeeRequest.getRole());
		employeeDetails.setSalary(employeeRequest.getSalary());
		employeeDetails.setAadhar(employeeRequest.getAadhar());
		
		return employeeDetails;
		
	}
	
}
