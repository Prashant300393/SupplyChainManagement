package com.amdocs.service;

import java.util.List;

import com.amdocs.model.ShipmentType;

public interface IShipmentTypeService {
	
	// 3. Copy Methods From IDao
	public Integer saveShipmentType(ShipmentType ob);
	
	public List<ShipmentType> getAllShipmentTypes();

	public void deleteShipmentType(Integer id);
	
	public ShipmentType getOneShipmentType(Integer id); 
	
	public void updatShipmentType(ShipmentType ob);


	public List<Object[ ]> getShipmentModeCount();


}
