package com.example.service;

import java.util.List;

import com.example.model.Invoice;

public interface InvoiceService {
	
	public List<Invoice> getInvoiceList();
	
	public Invoice getInvoice(String hdId);
	
	public Invoice addInvoice(Invoice invoice);
	
	public void updateInvoice(Invoice invoice);
	
	public void deleteInvoice(String hdId);
}
