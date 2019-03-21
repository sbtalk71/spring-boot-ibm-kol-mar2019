package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;
	
	@HystrixCommand(fallbackMethod="getEmpDetailsFallback")
	public ResponseEntity<String> getEmpDetails(int id){
		HttpHeaders headers= new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity req=new HttpEntity<>(headers);
		
		ResponseEntity<String> resp=rt.exchange("http://emp-service/emp/find?id="+id, 
															HttpMethod.GET, req, String.class);
		return resp;
		
		
	}
	
	public ResponseEntity<String> list(){
		HttpHeaders headers= new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity req=new HttpEntity<>(headers);
		
		ResponseEntity<String> resp=rt.exchange("http://emp-service/emp/list", 
															HttpMethod.GET, req, String.class);
		return resp;
		
		
	}
	
	
	//fallback
	
	public ResponseEntity<String> getEmpDetailsFallback(int id){
		return ResponseEntity.ok("Service is down, Try after sometime");
	}
	
}
