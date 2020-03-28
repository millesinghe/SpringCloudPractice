package com.springcloud.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springcloud.shop.filter.CustomFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyApplication.class, args);
	}
	
	//registering the filter
	@Bean
	public CustomFilter getCstmFilter1() {
		return new CustomFilter();
	}

}
