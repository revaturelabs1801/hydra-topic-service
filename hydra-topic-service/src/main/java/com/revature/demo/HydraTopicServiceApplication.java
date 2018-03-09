
package com.revature.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HydraTopicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydraTopicServiceApplication.class, args);
	}
}
