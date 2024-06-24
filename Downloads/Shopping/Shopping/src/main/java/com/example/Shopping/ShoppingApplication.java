// Create CRUD (create, read, update and delete) operation for a Product.
//This small spring boot application should have Controller and Service classes.
//Also write a GET API to get a list of products whose price is greater than 500 Rs.
package com.example.Shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

}
