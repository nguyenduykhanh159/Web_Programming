package com.example.demo;




import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.JobRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.cart.CartDTO;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.job.Job;
import com.example.demo.entity.order.Order;
import com.example.demo.entity.order.Product;
import com.example.demo.mapping.cart.CartMapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
		
	

	
	

}
