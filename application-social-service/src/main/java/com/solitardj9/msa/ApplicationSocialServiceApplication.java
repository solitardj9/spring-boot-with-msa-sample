package com.solitardj9.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationSocialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSocialServiceApplication.class, args);
	}
}