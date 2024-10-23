package com.example.Product_Service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	private static Long counter = 0l;
	
	@Autowired
	private ProductConfig productConfig;

	@Autowired
	private Environment environment;

	@Retry(name = "get-product", fallbackMethod = "getProductFallBack")
	@GetMapping("/product_info/{productName}")
	public Product getProduct(@PathVariable String productName) {

		logger.info("ProductController -> getProduct - " + (++counter)  + ", productName - " + productName);
		
		if (productName == null || productName.equalsIgnoreCase("BAD_PRODUCT")) {
			throw new RuntimeException("Bad Product");
		}

		logger.info("Product Details  - " + productConfig.getProducts() );

		return productConfig.getProducts().stream().filter(p -> p.getName().equalsIgnoreCase(productName)).findFirst()
				.orElseGet(() -> new Product());
	}

	private Product getProductFallBack(Exception ex) {
		Product product = new Product();
		product.setName("Dummy Product");
		return product;
	}
}
