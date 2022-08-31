package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.example.form.ValidGroup1;
import com.example.form.ValidGroup2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "staff")
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "com.example.config.StaffIDGenerator")
	private String nvId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 5,max = 150, groups = ValidGroup2.class)
	private String nvTen;
	
	@NotBlank(groups = ValidGroup1.class)
	private String nvGioiTinh;
	
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String nvEmail;
	
	@Pattern(regexp = "^[0-9]+", groups = ValidGroup1.class)
	@Length(min = 8, max = 14, groups = ValidGroup2.class)
	private String nvSdt;
	
	@ManyToOne
	@NotNull(groups = ValidGroup1.class)
	private Positions positions;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private List<Invoice> invoices;
}
