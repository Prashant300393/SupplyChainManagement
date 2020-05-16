package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class PurchaseDtl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "dtlid")
	private Integer id;
	
	@Transient
	private Integer slNo;
	
	private Integer qty;
	
	@ManyToOne
	@JoinColumn(name = "dtl_part_Fk")
	private Part part;
	
	
	// Also Written Bidirectional for this in Purchase Order
	@ManyToOne
	@JoinColumn(name = "dtl_po_Fk")
	private PurchaseOrder po;
	
	
}
