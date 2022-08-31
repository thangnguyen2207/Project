package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);
	
	public List<Customer> getCustomerList();
	
	public Customer getCustomer(String khId);
	
	public void deleteCustomer(String khId);
	
	public void updateCustomer(Customer customer);
}
