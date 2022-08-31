package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.form.ValidGroup1;
import com.example.form.ValidGroup2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "invoice_detail")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = ValidGroup1.class)
	private int ctId;
	
	@NotNull(groups = ValidGroup1.class)
	@Min(value = 1, groups = ValidGroup2.class)
	private int ctSoLuong;
	
	@NotNull(groups = ValidGroup1.class)
	@Min(value = 0, groups = ValidGroup2.class)
	private int ctGiaBan;
	
	@ManyToOne
	@NotNull
	private Invoice invoice;
	
	@ManyToOne
	@NotNull
	private Product product;
}
