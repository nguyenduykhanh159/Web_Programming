package com.example.demo;




import com.example.demo.entity.CustomUserDetails;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	
	@Override
	public void run(String... args) throws Exception {
		log.info("Helllo");
		log.error("Error");
		log.warn("Warn");
		
	}

}
