package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ProductGroup;
import com.example.repository.ProductGroupRepository;

@Service
public class ProductGroupServiceImpl implements ProductGroupService {
	@Autowired
	private ProductGroupRepository productGroupRepository;
	
	@Override
	public List<ProductGroup> getProductGroupList() {
		return productGroupRepository.findAll();
	}

	@Override
	public void deleteProGroupByIds(List<Integer> ids) {
		productGroupRepository.deleteAllById(ids);
	}

	@Override
	public void addProGroup(ProductGroup productGroup) {
		productGroupRepository.save(productGroup);
		
	}
	
	
}
