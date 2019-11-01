package com.logistic.shipment.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient

public class OrderDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDetailsServiceApplication.class, args);
	}

}
