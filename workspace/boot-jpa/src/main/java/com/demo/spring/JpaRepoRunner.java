package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class JpaRepoRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Emp(107, "Scott", "Mumbai", 99000));
		
		repo.findAll().stream().forEach(System.out::println);

	}

}












