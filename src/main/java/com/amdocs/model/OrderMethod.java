package com.amdocs.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "omtab")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderMethod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "omid")
	@NonNull
	private Integer orderId;
	@Column(name = "ommode")
	private String orderMode;
	@Column(name = "omcode")
	private String orderCode;
	@Column(name = "omtype")
	private String orderType;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "omaccpttab", joinColumns = @JoinColumn(name = "omid"))
	@OrderColumn(name = "pos")
	@Column(name = "accpt")
	private List<String> orderAccept;
	
	@Column(name = "omdesc")
	private String orderDesc;
	
}
