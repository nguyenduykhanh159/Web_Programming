package com.example.demo;




import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.JobRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.cart.CartDTO;
import com.example.demo.dto.cart.CartProductDTO;
import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.cart.Cart;
import com.example.demo.entity.job.Job;
import com.example.demo.entity.order.Order;
import com.example.demo.entity.order.OrderProduct;
import com.example.demo.entity.order.Product;
import com.example.demo.mapping.cart.Impl.CartMappingImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
