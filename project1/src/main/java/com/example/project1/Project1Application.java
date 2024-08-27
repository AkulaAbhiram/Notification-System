package com.example.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class Project1Application {

//	@Bean
//	@LoadBalanced
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
		//time out https
	}

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}
