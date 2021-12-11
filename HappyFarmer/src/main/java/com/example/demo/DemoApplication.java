package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Farmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {

		Farmer farmer=new Farmer();
		farmer.setAge(22);
		farmer.setAddress("Huu Van, Chuong My, Ha Noi");
		farmer.setName("Phung Xuan Quan");
		farmer.setPhone("0974654701");

		userRepository.save(farmer);
	}
}
