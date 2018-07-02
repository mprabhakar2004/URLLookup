package com.home.manish.URLAppenderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UrlAppenderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlAppenderServiceApplication.class, args);
	}
}
