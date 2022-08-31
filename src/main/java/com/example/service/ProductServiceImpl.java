package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Product> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(String hhId) {
		productRepository.deleteById(hhId);
	}

	@Override
	public Product getProduct(String hhId) {
		return productRepository.findById(hhId).orElse(null);
	}

	@Override
	public List<Product> getProductList(String name, int limit) {
		return entityManager.createQuery("SELECT p FROM Product p WHERE p.hhTen LIKE '%" + name + "%'" , Product.class)
				.setMaxResults(limit).getResultList();
	}

}
