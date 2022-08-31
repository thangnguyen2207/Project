package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.example.form.ValidGroup1;
import com.example.form.ValidGroup2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "com.example.config.CustomerIDGenerator")
	private String khId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 5, max = 150, groups = ValidGroup2.class)
	private String khTen;
	
	private String khDiaChi;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 8, max = 14, groups = ValidGroup2.class)
	private String khSdt;
	
	@NotBlank(groups = ValidGroup1.class)
	private String khLoai;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Invoice> invoices;
}
