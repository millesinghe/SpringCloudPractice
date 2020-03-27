package com.springcloud.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.shop.dao.Coupon;
import com.springcloud.shop.model.Product;
import com.springcloud.shop.repo.ProductRepo;
import com.springcloud.shop.restclient.CouponClient;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@Autowired
	CouponClient couponClient;

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
	}

	@GetMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable String id) {
		return repo.findById(Long.parseLong(id));
	}

}
