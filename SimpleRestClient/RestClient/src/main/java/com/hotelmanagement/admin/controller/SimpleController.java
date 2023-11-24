package com.hotelmanagement.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.admin.model.Coupon;
import com.hotelmanagement.admin.service.SimpleService;

@RestController
public class SimpleController {

	@Autowired
	SimpleService simpleService;

	@RequestMapping("/getCoupon")
	public Coupon getCoupons() {
		Coupon couponDetails = simpleService.getCouponDetails();
		return couponDetails;
	}

}
