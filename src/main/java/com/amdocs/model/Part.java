package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "parttab")
public class Part {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer partId;
	
	private String partCode;
	private Double partLen;
	private Double partWid;
	private Double partHgt;
	
	private Double baseCost;
	private String baseCurrency;
	/**
	 * Uom Integeration with Part using ManyToOne Multiplicity, many Parts can have one UOM(unit of measurement)
	 */
	@ManyToOne
	@JoinColumn(name = "uomIdFk")
	private Uom uomOb; // Has-A
	
	private String pdesc;

	@Transient
	private String dimen;
	
	public Part() {
		super();
	}
	
	public Part(Integer partId) {
		super();
		this.partId = partId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public Double getPartLen() {
		return partLen;
	}

	public void setPartLen(Double partLen) {
		this.partLen = partLen;
	}

	public Double getPartWid() {
		return partWid;
	}

	public void setPartWid(Double partWid) {
		this.partWid = partWid;
	}

	public Double getPartHgt() {
		return partHgt;
	}

	public void setPartHgt(Double partHgt) {
		this.partHgt = partHgt;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Uom getUomOb() {
		return uomOb;
	}

	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getDimen() {
		return dimen;
	}

	public void setDimen(String dimen) {
		this.dimen = dimen;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partLen=" + partLen + ", partWid=" + partWid
				+ ", partHgt=" + partHgt + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", uomOb="
				+ uomOb + ", pdesc=" + pdesc + ", dimen=" + dimen + "]";
	}
	
}