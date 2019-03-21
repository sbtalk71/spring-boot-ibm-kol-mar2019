package com.demo.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	EmpRepository repo;
	//@RequestMapping(path="/greet/{name}",method=RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	
	@GetMapping(path="/greet/{name}")
	public ResponseEntity greet(@PathVariable("name")String name) {
		return ResponseEntity.ok("Welcome to Spring REST, "+name);
	}
	
	@GetMapping(path="/emp/find",produces= {"application/json","application/xml"})
	public ResponseEntity findOneEmp(@RequestParam("id")int id) {
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(path="/emp/list",produces= {"application/json"})
	public ResponseEntity<List<Emp>> getAllEmps(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping(path="/emp/save",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e){
		
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Emp exists..");
			
		}else {
			repo.save(e);
			return ResponseEntity.ok("Emp Saved..");
		}
	}
	
}
