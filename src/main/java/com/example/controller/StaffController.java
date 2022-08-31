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
import com.example.model.Positions;
import com.example.model.Staff;
import com.example.service.PositionService;
import com.example.service.StaffService;

@Controller
@RequestMapping("/person")
public class StaffController {
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping("/staff")
	public String getStaff(Model model,
			@ModelAttribute Staff staff) {
		List<Staff> staffList = staffService.getStaffList();
		List<Positions> positionss = positionService.getPositions();
		Map<String, String> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("staffList", staffList);
		model.addAttribute("positionss", positionss);
		model.addAttribute("staff", staff);
		model.addAttribute("genderMap", genderMap);
		return "person/staff";
	}
	
	@PostMapping("/staff/add")
	public String addStaff(@ModelAttribute @Validated(GroupOrder.class) Staff staff, 
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {	
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "add");
			return getStaff(model, staff);
		}
		staffService.addStaff(staff);
		redirectAttributes.addFlashAttribute("showToast", "add");
		return "redirect:/person/staff";
	}
	
	@PostMapping("/staff/update")
	public String updateStaff(@ModelAttribute @Validated(GroupOrder.class) Staff staff,
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorStatus", "update");
			return getStaff(model, staff);
		}
		staffService.updateStaff(staff);
		redirectAttributes.addFlashAttribute("showToast", "update");
		return "redirect:/person/staff";
	}
	
	@GetMapping("/staff/delete/{nvId:.+}")
	public String deleteStaff(@PathVariable("nvId") String nvId, RedirectAttributes redirectAttributes) {
		staffService.deleteStaff(nvId);
		redirectAttributes.addFlashAttribute("showToast", "delete");
		return "redirect:/person/staff";
	}
}
