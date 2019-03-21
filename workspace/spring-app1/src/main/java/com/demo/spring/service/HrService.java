package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;
import com.demo.spring.log.MyLogger;

@Service
public class HrService {

	@Autowired	
	@Qualifier("jpaBean")	
	private EmpDao dao;
	
	//@Autowired
	//private MyLogger logger;
	
	public String registerEmp(int id, String name, String city, double salary) {
		//logger.logBefore();
		String resp=dao.save(new Emp(id, name, city, salary));
		//logger.logAfter();
		return resp;
	}
}
