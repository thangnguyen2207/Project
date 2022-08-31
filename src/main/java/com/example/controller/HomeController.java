package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String getHome() {
		return "home/home";
	}
	
	@PostMapping("/home")
	public String postHome() {
		return "home/home";
	}
}
