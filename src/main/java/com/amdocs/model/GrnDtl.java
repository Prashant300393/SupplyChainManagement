package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "grndtltab")
public class GrnDtl {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String partCode;
	private Double baseCost;
	private Integer qty;
	
	private String partStatus;
	
	// Integration with Parent  *....1
	@ManyToOne
	@JoinColumn(name = "grn_Id_Fk")
	private Grn grn;
	
}
