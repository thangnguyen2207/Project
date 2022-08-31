package com.example.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.GroupOrder;
import com.example.model.ProductGroup;
import com.example.service.ProductGroupService;

@Controller
public class ProductGroupController {
	@Autowired
	private ProductGroupService productGroupService;
	
	@PostMapping("/product-group/add")
	public String addProductGroup(@ModelAttribute @Validated(GroupOrder.class) ProductGroup productGroup, 
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			redirectAttributes.addAttribute("proGroupError", "1");
			return "redirect:/product";
		}
		productGroupService.addProGroup(productGroup);
		redirectAttributes.addFlashAttribute("showToast", "add");
		return "redirect:/product";
	}

	@PostMapping("/product-group/delete")
	public String deleteProductGroup(@RequestParam(name = "groupIds", required = false) Integer[] groupIds, RedirectAttributes redirectAttributes) {
		productGroupService.deleteProGroupByIds(Arrays.asList(groupIds));
		redirectAttributes.addFlashAttribute("showToast", "delete");
		return "redirect:/product";
	}
	
//	@PostMapping("/product/group")
//	public String deleteProductGroup(@RequestParam(name = "image", required = false) MultipartFile image) throws IOException {
//		String folder = "\\LaptrinhWeb-2\\photos\\";
//		Path path = Paths.get(folder + image.getOriginalFilename());
//		Files.write(path, image.getBytes());
//		return "redirect:/product";
//	}
}
