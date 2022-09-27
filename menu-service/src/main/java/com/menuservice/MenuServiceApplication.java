package com.menuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import org.springframework.stereotype.Service;

//import com.Subscription.Model.Subscription;


@SpringBootApplication
@EnableEurekaClient
public class MenuServiceApplication {
	
	//It's the face of application which consists of main method to run the application
	public static void main(String[] args) {
		SpringApplication.run(MenuServiceApplication.class, args);
	}




}
