package com.example.service;

import java.util.List;

import com.example.model.ProductGroup;

public interface ProductGroupService {
	
	public List<ProductGroup> getProductGroupList();
	
	public void addProGroup(ProductGroup productGroup);
	
	public void deleteProGroupByIds(List<Integer> ids);
}
