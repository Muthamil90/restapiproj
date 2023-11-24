package com.bharath.springcloud.security.config;

import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class secuFilterChain implements SecurityFilterChain {

	@Override
	public boolean matches(HttpServletRequest request) {
		String header = request.getHeader("Application-name");
		if (header.equalsIgnoreCase("ABCD")) {
			System.out.println("abc");
			return true;
		}
		return false;
	}

	@Override
	public List<Filter> getFilters() {
		return Arrays.asList();
	}

}
