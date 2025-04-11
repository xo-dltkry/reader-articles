package com.iitu.reader_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReaderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReaderServiceApplication.class, args);
	}
}
