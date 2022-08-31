package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Invoice;
import com.example.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> getInvoiceList() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice addInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	@Override
	public void deleteInvoice(String hdId) {
		invoiceRepository.deleteById(hdId);	
	}

	@Override
	public Invoice getInvoice(String hdId) {
		return invoiceRepository.getById(hdId);
	}
	
}
