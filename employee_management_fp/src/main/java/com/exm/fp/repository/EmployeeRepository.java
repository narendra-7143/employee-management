package com.exm.fp.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exm.fp.entity.Employee;
import com.exm.fp.enums.StatusType;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	Boolean existsByAadharAndStatusNot(String aadhar, StatusType status);
	
	@Query("SELECT e FROM Employee e WHERE e.id = :employeeId AND e.status = :status")
	Optional<Employee> findByEmployeeAndStatus(@Param("employeeId")String employeeId, @Param("status")StatusType status);
	
	@Query("SELECT e FROM Employee e WHERE e.status = :status")
	Optional<Page<Employee>> findAllEmployees(@Param("status")StatusType status, Pageable pageable);
}
