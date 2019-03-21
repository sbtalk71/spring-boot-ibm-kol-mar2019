package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class YourTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("YourTestRunner : Command executed....");
	}

}
