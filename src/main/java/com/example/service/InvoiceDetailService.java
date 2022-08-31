package com.example.service;

import com.example.model.InvoiceDetail;

public interface InvoiceDetailService {
	
	public void addInvoiceDetail(InvoiceDetail invoiceDetail);
	
	public void updateInvoiceDetail(InvoiceDetail invoiceDetail);
	
	public void deleteInvoiceDetail(int ctId);
}
