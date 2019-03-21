package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.service.HrService;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext ctx
		=new AnnotationConfigApplicationContext(AppConfig.class);
		
		HrService service=(HrService)ctx.getBean("hrService");
		
		System.out.println(service.registerEmp(100, "Chatur", "Mumbai", 56000));
		
		//EmpDao d1=(EmpDao)ctx.getBean("jpaBean");
		
		//EmpDao d2=(EmpDao)ctx.getBean("empDaoJPAImpl");
		
		//System.out.println(d1==d2);
		
		System.out.println(service.getClass().getName());

	}

}
