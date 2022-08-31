package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {

	public List<Product> getProductList();
	
	public List<Product> getProductList(String name, int limit);
	
	public Product getProduct(String hhId);
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(String hhId);
}
