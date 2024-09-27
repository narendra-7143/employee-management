package com.exm.fp.entity;

import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.exm.fp.enums.StatusType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	   @Id
	    @Column(name = "id", length = 36, nullable = false)
	    private String id;

	    @CreationTimestamp
	    @Column(name = "created_time", nullable = false)
	    private Instant createdTime;

	    @UpdateTimestamp
	    @Column(name = "updated_time")
	    private Instant updatedTime;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "status", length = 12, nullable = false)
	    private StatusType status;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name = "gender", length = 12, nullable = false)
	    private Gender gender;

	    @Column(name = "name", length = 36, nullable = false)
	    private String name;
	    
	    @Column(name= "salary", nullable = false)
	    private Integer salary;
	    
	    @Column(name= "role", length = 36, nullable = false)
	    private String role;
	    
	    @Column(name = "age",nullable = false)
	    private Integer age;
	    
	    @Column(name = "phone_number", nullable = false)
	    private String phoneNumber;
	    
	    @Column(name = "aadhar", nullable = false)
	    private String aadhar;

		public String getAadhar() {
			return aadhar;
		}

		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
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

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Instant getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(Instant createdTime) {
			this.createdTime = createdTime;
		}

		public Instant getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(Instant updatedTime) {
			this.updatedTime = updatedTime;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
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
	    	
}
