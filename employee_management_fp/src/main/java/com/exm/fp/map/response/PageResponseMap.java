package com.exm.fp.map.response;

import org.springframework.data.domain.Page;

import com.exm.fp.response.EmployeeResponse;
import com.exm.fp.response.PageResponse;

public class PageResponseMap {
		
		public PageResponse<EmployeeResponse> responseMap(Page<EmployeeResponse> employeeResponse){
			
			PageResponse<EmployeeResponse> response = new PageResponse<>();
			
			response.setContent(employeeResponse.getContent());
			response.setCurrentPage(employeeResponse.getNumber());
			response.setPageSize(employeeResponse.getSize());
			response.setTotalElements(employeeResponse.getTotalElements());
			response.setTotalPages(employeeResponse.getTotalPages());
			
			return response;
			
	}
}
