package com.learn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/home/failed")
	public String failed() {
		return "failed";
		
	}
	
	@PostMapping("/home/process")
	public String process() {
		return "books";
	}
}
