package com.amdocs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	// Integration for 1...1 relation using *...1 with Unique=TRUE
	@ManyToOne
	@JoinColumn(name = "poIdFk", unique = true)
	private PurchaseOrder po;
	
	// BiDirectional mapping
	@OneToMany(mappedBy = "grn", fetch = FetchType.EAGER)
	private List<GrnDtl> grnDtl;
	
}
