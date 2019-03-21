package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestGetClient implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate rt= new RestTemplate();
		HttpHeaders headers= new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity req=new HttpEntity<>(headers);
		
		ResponseEntity<String> resp=rt.exchange("http://localhost:8080/emp/find?id=104", 
															HttpMethod.GET, req, String.class);
		
		System.out.println(resp.getBody());
		
		

	}

}
