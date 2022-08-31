package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.InvoiceDetail;
import com.example.repository.InvoiceDetailRepository;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;
	
	@Override
	public void addInvoiceDetail(InvoiceDetail invoiceDetail) {
		invoiceDetailRepository.save(invoiceDetail);
	}

	@Override
	public void updateInvoiceDetail(InvoiceDetail invoiceDetail) {
		invoiceDetailRepository.save(invoiceDetail);
	}

	@Override
	public void deleteInvoiceDetail(int ctId) {
		invoiceDetailRepository.deleteById(ctId);
	}

}
