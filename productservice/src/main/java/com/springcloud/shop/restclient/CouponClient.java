package com.springcloud.shop.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcloud.shop.dao.Coupon;

@FeignClient("coupon-service")
public interface CouponClient {

	@GetMapping("/coupon-api/coupons/{code}")
	Coupon getCoupon(@PathVariable String code);
}
