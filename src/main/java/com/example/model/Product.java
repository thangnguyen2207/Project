package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.example.form.ValidGroup1;
import com.example.form.ValidGroup2;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "com.example.config.ProductIDGenerator")
	private String hhId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 5, max = 150, groups = ValidGroup2.class)
	private String hhTen;
	
	@NotBlank(groups = ValidGroup1.class)
	private String hhDonViTinh;
	
	@NotNull(groups = ValidGroup1.class)
	@Min(value = 0)
	private int hhSoLuongTon;
	
	@NotNull(groups = ValidGroup1.class)
	@Min(value = 0)
	private int hhDonGia;
	
	private String hhMoTa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@NotNull(groups = ValidGroup1.class)
	private ProductGroup productGroup;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<InvoiceDetail> invoiceDetails;
}
