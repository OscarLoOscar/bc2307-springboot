package com.hkjava.demo.demofinnhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkjava.demo.demofinnhub.infra.RedisHelper;

@SpringBootApplication
public class DemoFinnhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFinnhubApplication.class, args);
		System.out.println("Server start completed");

	}

}
