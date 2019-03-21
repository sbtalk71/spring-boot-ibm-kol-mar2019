package com.demo.spring.log;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogger {
	@Pointcut("execution(* com..service.Hr*.reg*(..))")
	private void pcut() {}

	@Before("pcut()")
	public void logBeforeB() {
		System.out.println("Before call to registerEmp--2");
	}
	
	@Before("pcut()")
	public void logBeforeA() {
		System.out.println("Before call to registerEmp--1");
	}
	
	@AfterReturning("pcut()")
	public void logAfter() {
		System.out.println("After call to registerEmp");
	}
}
