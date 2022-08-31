package com.example.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.example.form.ValidGroup1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "invoice")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "com.example.config.InvoiceIDGenerator")
	private String hdId;
	
	@NotNull(groups = ValidGroup1.class)
	private Date hdNgay;
	
	@NotBlank(groups = ValidGroup1.class)
	private String hdLoai;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Staff staff;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Customer customer;
	
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<InvoiceDetail> invoiceDetails;
}
