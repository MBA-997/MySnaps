package com.example.bilal.MySnap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.example.bilal.MySnap" })
//@EntityScan(basePackages = "com.example.bilal.MySnap")
public class MySnapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySnapApplication.class, args);
	}

}
