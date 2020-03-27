package com.springcloud.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.shop.model.Product;
import com.springcloud.shop.repo.ProductRepo;

@RestController
@RequestMapping("/product-api")
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable String id) {
		return repo.findById(Long.parseLong(id));
	}

}
