package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.service.UserApplicationService;
import com.example.model.Customer;
import com.example.model.Invoice;
import com.example.model.Staff;
import com.example.service.CustomerService;
import com.example.service.InvoiceService;
import com.example.service.StaffService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/invoice")
	public String getInvoice(@ModelAttribute Invoice invoice, BindingResult result, Model model) {
		List<Invoice> invoiceList = invoiceService.getInvoiceList();
		List<Customer> customers = customerService.getCustomerList();
		List<Staff> staffs = staffService.getStaffList();
		Map<String, String> invoiceTypeMap = userApplicationService.getInvoiceTypeMap();
		model.addAttribute("invoiceTypeMap", invoiceTypeMap);
		model.addAttribute("invoiceList", invoiceList);
		model.addAttribute("customers", customers);
		model.addAttribute("staffs", staffs);
		return "invoice/invoice";
	}
	
//	@PostMapping("/invoice/add")
//	public String addInvoice(@ModelAttribute @Validated(GroupOrder.class) Invoice invoice,
//			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
//		invoice.setCustomer(null);
//		invoice.setStaff(null);
//		if (result.hasErrors()) {
//			model.addAttribute("errorStatus", "add");			
//			return getInvoice(invoice, result, model);
//		}
//
//		invoiceService.addInvoice(invoice);
//		redirectAttributes.addFlashAttribute("showToast", "add");
//		return "redirect:/invoice";
//	}
	
	@GetMapping("/invoice/add")
	public String addInvoice(@ModelAttribute Invoice invoice, Model model) {
		invoice.setHdNgay(new java.sql.Date(System.currentTimeMillis()));
		invoice.setHdLoai("n");
		Invoice inv = invoiceService.addInvoice(invoice);
		return "redirect:/invoice/detail/" + inv.getHdId();
	}
	
	@PostMapping("/invoice/update")
	public String updateInvoice(@ModelAttribute Invoice invoice,
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		log.info(invoice.toString());
		if (invoice.getCustomer().getKhId().equals("")) 
			invoice.setCustomer(null);
		if (invoice.getStaff().getNvId().equals(""))
			invoice.setStaff(null);
		invoiceService.updateInvoice(invoice);
		redirectAttributes.addFlashAttribute("showToast", "update");
		return "redirect:/invoice";
	}
	
	@GetMapping("/invoice/delete/{hdId:.+}")
	public String deleteInvoice(@PathVariable("hdId") String hdId, RedirectAttributes redirectAttributes) {
		invoiceService.deleteInvoice(hdId);
		redirectAttributes.addFlashAttribute("showToast", "delete");
		return "redirect:/invoice";
	}
}
