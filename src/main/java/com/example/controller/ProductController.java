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
import com.example.model.Product;
import com.example.model.ProductGroup;
import com.example.service.ProductGroupService;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductGroupService productGroupService;
	
	@GetMapping("/product")
	public String getProduct(@ModelAttribute Product product, BindingResult result, Model model) {
		ProductGroup productGroup = new ProductGroup();
		List<Product> productList = productService.getProductList();
		List<ProductGroup> productGroupList = productGroupService.getProductGroupList();
		model.addAttribute("productGroup", productGroup);
		model.addAttribute("productList", productList);
		model.addAttribute("product", product);
		model.addAttribute("productGroupList", productGroupList);
		return "product/product";
	}
	
	@PostMapping("/product/add")
	public String addProduct(@ModelAttribute @Validated(GroupOrder.class) Product product, 
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		product.setHhSoLuongTon(0);
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "add");
			return getProduct(product, result, model);
		}
		
		productService.addProduct(product);
		redirectAttributes.addFlashAttribute("showToast", "add");
		return "redirect:/product";
	}
	
	@PostMapping("/product/update")
	public String updateProduct(@ModelAttribute @Validated(GroupOrder.class) Product product, 
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "update");
			return getProduct(product, result, model);
		}
		productService.updateProduct(product);
		redirectAttributes.addFlashAttribute("showToast", "update");
		return "redirect:/product";
	}
	
	@GetMapping("/product/delete/{hhId:.+}")
	public String deleteProduct(@PathVariable("hhId") String hhId, RedirectAttributes redirectAttributes) {
		productService.deleteProduct(hhId);
		redirectAttributes.addFlashAttribute("showToast", "delete");
		return "redirect:/product";
	}
}
