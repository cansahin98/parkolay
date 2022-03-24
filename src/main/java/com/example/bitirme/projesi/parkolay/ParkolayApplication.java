package com.example.bitirme.projesi.parkolay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.example.bitirme.projesi")
public class ParkolayApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ParkolayApplication.class, args);
	}
}
