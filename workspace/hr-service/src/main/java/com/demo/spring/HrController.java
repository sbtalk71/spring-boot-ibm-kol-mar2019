package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrController {

	@Autowired
	HrService service;
	@GetMapping(path="/hr/find/{id}",produces="application/json")
	public ResponseEntity<String> findEmp(@PathVariable("id")int id){
		return service.getEmpDetails(id);
	}
	
	@GetMapping(path="/hr/list",produces="application/json")
	public ResponseEntity<String> listAll(){
		return service.list();
	}
}
