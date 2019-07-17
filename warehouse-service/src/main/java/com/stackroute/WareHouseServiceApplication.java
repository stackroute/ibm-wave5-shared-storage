package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WareHouseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WareHouseServiceApplication.class, args);
	}

}
