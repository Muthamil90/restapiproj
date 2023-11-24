package com.bharath.springcloud.security.controllers;

import java.math.BigDecimal;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.security.entities.Coupon;
import com.bharath.springcloud.security.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo repo;

	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon, HttpServletRequest request, HttpServletResponse response) {
		coupon.setCode("SUPERSALE");
		coupon.setDiscount(new BigDecimal(10));
		coupon.setExpDate("31-12-2023");
		coupon.setId(1l);
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		return coupon;

	}

	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}

	@GetMapping("/getCoupon")
	public Coupon getCoupon1() {
		Coupon coupon = new Coupon();
		coupon.setCode("SUPERSALE");
		coupon.setDiscount(new BigDecimal(10));
		coupon.setExpDate("31-12-2023");
		coupon.setId(1l);
		return coupon;
		
	}
}
