package com.klef.fsad.exam;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.klef.fsad.exam")
public class HotelApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(HotelApplication.class, args);
	}

}
