package com.hotelmanagement.admin.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelmanagement.admin.model.Coupon;

@Service
public class SimpleService {

	public Coupon getCouponDetails() {

		String input = "{\r\n" + "    \"code\": \"SUPERSALE\",\r\n" + "    \"discount\": 10,\r\n"
				+ "    \"expDate\": \"31-12-2023\"\r\n" + "}";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.add("Application-name", "AUTH");
		header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(input, header);
		Coupon coupon = null;
		try {
			coupon = restTemplate.postForObject("http://localhost:8090/couponapi/coupons", entity, Coupon.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coupon;
	}
}
