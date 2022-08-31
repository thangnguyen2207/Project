package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.form.ValidGroup1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_group")
@AllArgsConstructor
@NoArgsConstructor
public class ProductGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nhId;
	
	@NotBlank(groups = ValidGroup1.class)
	private String nhTen;
	
	@OneToMany(mappedBy = "productGroup", cascade = CascadeType.ALL)
	private List<Product> products;
}
