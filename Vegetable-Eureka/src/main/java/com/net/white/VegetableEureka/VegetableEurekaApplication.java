package com.net.white.VegetableEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VegetableEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VegetableEurekaApplication.class, args);
	}

}

