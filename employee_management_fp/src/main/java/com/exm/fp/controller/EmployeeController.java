package com.exm.fp.controller;

import com.exm.fp.enums.StatusType;
import com.exm.fp.request.EmployeeRequest;
import com.exm.fp.response.EmployeeResponse;
import com.exm.fp.response.Message;
import com.exm.fp.response.PageResponse;
import com.exm.fp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@CrossOrigin("*")
@Validated
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	

    @Autowired
    private EmployeeService employeeService;

    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Message> createEmployee(
    		@RequestBody @Valid EmployeeRequest employeeRequest) {

    		String message = employeeService.createEmployee(employeeRequest);
    		return ResponseEntity.ok(new Message(message));  	
    }

    
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Message> updateEmployee(@PathVariable String id, @RequestBody @Valid EmployeeRequest employeeRequest){

    		String message = employeeService.updateEmployee(id, employeeRequest);
    		return ResponseEntity.ok(new Message(message));
    }

    
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable String id) {

    		 EmployeeResponse response = employeeService.getById(id);
    	        return ResponseEntity.ok(response);
    }

    
    @GetMapping(produces = "application/json")
    public ResponseEntity<PageResponse<EmployeeResponse>> getAllEmployees(@RequestParam(name = "page", defaultValue = "0") int page,
	        @RequestParam(name = "size", defaultValue = "10") int size) {
   
    		PageResponse<EmployeeResponse> responses = employeeService.getAllEmployees(page, size);
            return ResponseEntity.ok(responses);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> deleteEmployeeById(@PathVariable String id) {

		 	String response = employeeService.deleteEmployee(id);
	        return ResponseEntity.ok(new Message(response));
    }
    
    @PatchMapping(value = "/id/{id}/status/{status}")
    public ResponseEntity<Message> updateEmployee(@PathVariable String id, @PathVariable StatusType status){
    	
    	String response = employeeService.updateStatus(id, status);
    	return ResponseEntity.ok(new Message(response));
    }
    
}

