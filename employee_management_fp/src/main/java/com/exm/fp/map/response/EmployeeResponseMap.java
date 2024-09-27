package com.exm.fp.map.response;


import com.exm.fp.entity.Employee;
import com.exm.fp.response.EmployeeResponse;


public class EmployeeResponseMap {

	public EmployeeResponse responseMap(Employee employee) {
		
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		employeeResponse.setId(employee.getId());
		employeeResponse.setAadhar(employee.getAadhar());
		employeeResponse.setAge(employee.getAge());
		employeeResponse.setGender(employee.getGender());
		employeeResponse.setName(employee.getName());
		employeeResponse.setPhoneNumber(employee.getPhoneNumber());
		employeeResponse.setRole(employee.getRole());
		employeeResponse.setSalary(employee.getSalary());
		
		return employeeResponse;
	}
	
}
