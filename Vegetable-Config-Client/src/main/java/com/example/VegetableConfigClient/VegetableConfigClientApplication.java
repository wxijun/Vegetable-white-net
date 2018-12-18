package com.example.VegetableConfigClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VegetableConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(VegetableConfigClientApplication.class, args);
	}

}

