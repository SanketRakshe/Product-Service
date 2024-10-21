package com.example.Product_Service.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.example.Product_Service.model.Product;

@Component
@ConfigurationProperties(prefix = "product-service")
public class ProductConfig {
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
