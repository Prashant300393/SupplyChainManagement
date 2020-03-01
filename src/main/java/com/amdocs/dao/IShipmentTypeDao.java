package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.ShipmentType;

public interface IShipmentTypeDao {

	// 1. Add Abstract Method to perform Operation
	public Integer saveShipmentType(ShipmentType ob);
	
	public List<ShipmentType> getAllShipmentTypes();
	
	public void deleteShipmentType(Integer id);
	
	ShipmentType getOneShipmentType(Integer id);
	
	void updatShipmentType(ShipmentType ob);

	List<Object[ ]> getShipmentModeCount();


}
