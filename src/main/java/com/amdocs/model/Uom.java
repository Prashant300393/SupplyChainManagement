package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uomtab")
public class Uom{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer uomId;
	@Column(name = "utype")
	private String uomType;
	@Column(name = "umodel")
	private String uomModel;
	@Column(name = "udesc")
	private String uomDesc;

	public Uom() {
		super();
	}
	// 1- arg - Constructor	
	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}
	
	public Integer getUomId() {
		return uomId;
	}
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getUomDesc() {
		return uomDesc;
	}
	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDesc=" + uomDesc + "]";
	}
}
