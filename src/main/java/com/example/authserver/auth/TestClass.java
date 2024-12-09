package com.example.authserver.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
