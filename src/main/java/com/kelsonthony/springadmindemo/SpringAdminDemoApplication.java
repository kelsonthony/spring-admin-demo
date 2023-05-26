package com.kelsonthony.springadmindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAdminServer
@SpringBootApplication
public class SpringAdminDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdminDemoApplication.class, args);
	}

}
