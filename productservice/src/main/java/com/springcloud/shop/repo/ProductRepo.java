package com.springcloud.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.shop.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
