package com.example.Product_Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product_Service.configuration.ProductConfig;
import com.example.Product_Service.model.Product;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ProductController {
	
	@Autowired
	private ProductConfig productConfig;
	
	@Autowired
	private Environment environment;
	
	@Retry(name = "get-product")
	@GetMapping("/product_info/{productName}")
	public Product getProduct(@PathVariable String productName) {
		
		System.out.println("/product_info -----------------");
		if (productName == null || productName.equalsIgnoreCase("BAD_PRODUCT")) {
			throw new RuntimeException("Bad Product");
		}
		
		System.out.println("Port - "
				+ environment.getProperty("local.server.port"));
		
		return productConfig.getProducts()
				.stream()
				.filter(
						 p -> p.getName().equalsIgnoreCase(productName))
				.findFirst()
				.orElseGet(() -> new Product());
	}
}
