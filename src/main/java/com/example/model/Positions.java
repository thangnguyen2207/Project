package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "positions")
@AllArgsConstructor
@NoArgsConstructor
public class Positions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvId;
	
	private String cvTen;
	
	@OneToMany(mappedBy = "positions", cascade = CascadeType.ALL)
	private List<Staff> staffs;
	
}
