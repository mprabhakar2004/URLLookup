package com.home.manish.urllookupservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UrlLookupServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlLookupServiceApplication.class, args);
	}
}
