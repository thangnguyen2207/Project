package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.service.UserApplicationService;
import com.example.form.GroupOrder;
import com.example.model.Customer;
import com.example.service.CustomerService;

@Controller
@RequestMapping("/person")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/customer")
	public String getCustomers(@ModelAttribute Customer customer, Model model) {
		List<Customer> customerList = customerService.getCustomerList();
		Map<String, String> typeMap = userApplicationService.getTypeMap();
		model.addAttribute("customerList", customerList);
		model.addAttribute("customer", customer);
		model.addAttribute("typeMap", typeMap);
		return "person/customer";
	}
	
	@PostMapping("/customer/add")
	public String addCustomer(@ModelAttribute @Validated(GroupOrder.class) Customer customer, 
			BindingResult result, RedirectAttributes redirectAttributes , Model model) {	
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "add");
			return getCustomers(customer, model);
		}
		customerService.addCustomer(customer);
		redirectAttributes.addFlashAttribute("showToast", "add");
		return "redirect:/person/customer";
	}
	
	@PostMapping("/customer/update")
	public String updateCustomer(@ModelAttribute @Validated(GroupOrder.class) Customer customer,
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "update");
			return getCustomers(customer, model);
		}
		customerService.updateCustomer(customer);
		redirectAttributes.addFlashAttribute("showToast", "update");
		return "redirect:/person/customer";
	}
	
	@GetMapping("/customer/delete/{khId:.+}")
	public String deleteCustomer(@PathVariable("khId") String khId, RedirectAttributes redirectAttributes) {
		customerService.deleteCustomer(khId);
		redirectAttributes.addFlashAttribute("showToast", "delete");
		return "redirect:/person/customer";
	}
}
