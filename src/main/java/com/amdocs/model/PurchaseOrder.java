package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "potab")
public class PurchaseOrder {

	@NonNull
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "ordercode")
	private String poOrderCode;
	
	@ManyToOne
	@JoinColumn(name = "shipIdFk")
	private ShipmentType shipOb;

	@ManyToOne
	@JoinColumn(name = "whUserIdFk")
	private WhUserType whVendor;
	
	@Column(name = "refnumber")
	private String poRefNum;
	@Column(name = "qltycheck")
	private String poQltyCheck;
	@Column(name = "status")
	private String poStatus;
	@Column(name = "note")
	private String poDesc;
	
}
