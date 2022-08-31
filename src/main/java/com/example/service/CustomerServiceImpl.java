package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(String khId) {
		customerRepository.deleteById(khId);	
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(String khId) {
		return customerRepository.findById(khId).orElse(null);
	}
	
}
