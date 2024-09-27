package com.exm.fp.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exm.fp.entity.Employee;
import com.exm.fp.enums.StatusType;
import com.exm.fp.exceptions.ResourceInvalidException;
import com.exm.fp.exceptions.ResourceNotFoundException;
import com.exm.fp.map.request.EmployeeRequestMap;
import com.exm.fp.map.response.EmployeeResponseMap;
import com.exm.fp.map.response.PageResponseMap;
import com.exm.fp.repository.EmployeeRepository;
import com.exm.fp.request.EmployeeRequest;
import com.exm.fp.response.EmployeeResponse;
import com.exm.fp.response.PageResponse;

import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	public String createEmployee(EmployeeRequest employeeRequest) {
		
		Boolean checkAadhar = employeeRepository.existsByAadharAndStatusNot(employeeRequest.getAadhar(),
				StatusType.DELETED);
		if(checkAadhar) {
			throw new ResourceInvalidException("Employee already exists");
		}
		EmployeeRequestMap employeeRequestMap = new EmployeeRequestMap();
		Employee employee = employeeRequestMap.createRequestMap(employeeRequest);
		employeeRepository.save(employee);
		return "Employee details saved successfully";
	}
	
	public String updateEmployee(String id, EmployeeRequest employeeRequest) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		if(!employee.getAadhar().equals(employeeRequest.getAadhar())) {
			throw new ResourceInvalidException("Aadhar doesnot match");
		}
		EmployeeRequestMap employeeRequestMap = new EmployeeRequestMap();
		Employee updateEmployee = employeeRequestMap.updateRequestMap(employee, employeeRequest);
		employeeRepository.save(updateEmployee);
		return "Employee details updated successfully";
	}
	
	public EmployeeResponse getById(String id) {
		
		Employee employee = employeeRepository.findByEmployeeAndStatus(id, StatusType.ACTIVE).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		EmployeeResponseMap employeeResponseMap = new EmployeeResponseMap();
		return employeeResponseMap.responseMap(employee);
	}
	
	public PageResponse<EmployeeResponse> getAllEmployees(int page, int size){
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Employee> allEmployees = employeeRepository.findAllEmployees(StatusType.ACTIVE, pageable).orElseThrow(() -> 
		new ResourceNotFoundException("Employees not found"));
		
		EmployeeResponseMap employeeResponseMap = new EmployeeResponseMap();
		Page<EmployeeResponse> employeesList = allEmployees.map(employeeResponseMap :: responseMap);
		    
		    PageResponseMap pageResponseMap = new PageResponseMap();
		    
		    return pageResponseMap.responseMap(employeesList);
	}
	
	public String deleteEmployee(String id) {
	
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employeeRepository.delete(employee);
		return "Employee deleted";
	}
	
	public String updateStatus(String id, StatusType status) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employee.setStatus(status);
		employeeRepository.save(employee);
		return "Employee status updated successfully";
	}
}




