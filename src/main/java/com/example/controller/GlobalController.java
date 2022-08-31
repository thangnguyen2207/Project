package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.model.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalController {
	
	@ModelAttribute("userName")
	public Account globalAccountObject(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			model.addAttribute("userName", authentication.getName());
			Account account = new Account(0 ,authentication.getName(), "");
			return account;
		}
		return new Account();
	}
}
