package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer(null, "Safae","safae@gmail.com"));
			customerRepository.save(new Customer(null, "hamid","hamid@gmail.com"));
			customerRepository.save(new Customer(null, "Hind","hind@gmail.com"));
			customerRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}
