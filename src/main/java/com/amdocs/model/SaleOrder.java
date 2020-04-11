package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "saletab")
public class SaleOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NonNull
	@Column(name = "id")
	private Integer saleId;
	@Column(name = "code")
	private String saleCode;
	
	@ManyToOne
	@JoinColumn(name = "shipIdFk")
	private ShipmentType shipOb;
	
	@ManyToOne
	@JoinColumn(name = "whUserIdFk")
	private WhUserType whCust;
		
	@Column(name = "refno")
	private String saleRefNo;
	private String stockMode;
	private String stockSource;
	private String status;
	@Column(name = "note")
	private String saleDesc;
}
