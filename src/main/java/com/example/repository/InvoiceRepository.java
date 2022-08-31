package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
