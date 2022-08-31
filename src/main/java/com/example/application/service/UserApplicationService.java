package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	
	public Map<String, String> getGenderMap() {
		Map<String, String> genderMap = new LinkedHashMap<>();
		genderMap.put("Nam", "1");
		genderMap.put("Nữ", "2");
		return genderMap;
	}
	
	public Map<String, String> getTypeMap() {
		Map<String, String> typeMap = new LinkedHashMap<>();
		typeMap.put("Nhà cung cấp", "ncc");
		typeMap.put("Khách mua hàng", "kmh");
		return typeMap;
	}
	
	public Map<String, String> getInvoiceTypeMap() {
		Map<String, String> invoiceTypeMap = new LinkedHashMap<>();
		invoiceTypeMap.put("Nhập", "n");
		invoiceTypeMap.put("Xuất", "x");
		return invoiceTypeMap;
	}
}
