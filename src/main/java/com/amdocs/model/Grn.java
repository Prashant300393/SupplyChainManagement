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
@Table(name = "grntab")
public class Grn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String grnCode;
	private String grnType;
	private String note;
	
	// Integration
	@ManyToOne
	@JoinColumn(name = "poIdFk", unique = true)
	private PurchaseOrder po;
	
	
}
