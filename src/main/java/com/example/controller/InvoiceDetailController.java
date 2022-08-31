package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.GroupOrder;
import com.example.model.Invoice;
import com.example.model.InvoiceDetail;
import com.example.model.Product;
import com.example.service.InvoiceDetailService;
import com.example.service.InvoiceService;
import com.example.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InvoiceDetailController {
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	
	@GetMapping("/invoice/detail/{hdId:.+}")
	public String getInvoiceDetail(@PathVariable("hdId") String hdId,
			@ModelAttribute InvoiceDetail invoiceDetail, BindingResult result, Model model) {
		Invoice invoice = invoiceService.getInvoice(hdId);
		List<Product> products = productService.getProductList();
		
		int total = 0;
		if (invoice.getInvoiceDetails() != null) {
			for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
				if (detail.getProduct() != null) {
					detail.setProduct(productService.getProduct(detail.getProduct().getHhId()));
				}
				total += detail.getCtSoLuong() * detail.getCtGiaBan();
			}
		}
		model.addAttribute("invoice", invoice);
		model.addAttribute("products", products);
		model.addAttribute("total", total);
		return "invoice/invoice_detail";
	}
	
	@PostMapping("/invoice/detail/add")
	public String addInvoiceDetail(@ModelAttribute @Validated(GroupOrder.class) InvoiceDetail invoiceDetail,
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {	
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "add");
			return getInvoiceDetail(invoiceDetail.getInvoice().getHdId(), invoiceDetail, result, model);
		}
		
		invoiceDetailService.addInvoiceDetail(invoiceDetail);
		redirectAttributes.addFlashAttribute("showToast", "add");
		return "redirect:/invoice/detail/" + invoiceDetail.getInvoice().getHdId();
	}
	
	@PostMapping("/invoice/detail/update")
	public String updateInvoiceDetail(@ModelAttribute @Validated(GroupOrder.class) InvoiceDetail invoiceDetail,
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "update");
			return getInvoiceDetail(invoiceDetail.getInvoice().getHdId(), invoiceDetail, result, model);
		}
		
		invoiceDetailService.updateInvoiceDetail(invoiceDetail);
		redirectAttributes.addFlashAttribute("showToast", "update");
		return "redirect:/invoice/detail/" + invoiceDetail.getInvoice().getHdId();
	}
	
	@GetMapping("/invoice/detail/delete/{ctId:.+}/{hdId:.+}")
	public String deleteProduct(@PathVariable("ctId") String ctId, @PathVariable("hdId") String hdId,
			RedirectAttributes redirectAttributes) {
		invoiceDetailService.deleteInvoiceDetail(Integer.parseInt(ctId));
		redirectAttributes.addFlashAttribute("showToast", "delete");
		return "redirect:/invoice/detail/" + hdId;
	}
	
	@PostMapping("invoice/detail/search-product/{name}&{limit}")
	public String searchProductList(@PathVariable String name, @PathVariable int limit, Model model) {
		List<Product> products = productService.getProductList(name, limit);
		log.info(products.size() + "");
		model.addAttribute("products", products);
		return "product/searchItem";
	}

}
