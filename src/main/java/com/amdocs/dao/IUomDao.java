package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.Uom;

public interface IUomDao {
	
	// INSERTING DATA : Serializable (PrimaryKey) , we have to DownCast to Integer
	Integer saveUom(Uom ob);
	
	// FETCHING DATA FROM DATABASE
	List<Uom> getAllUoms();

	void deleteUom(Integer id);
	
	Uom getOneUom(Integer id);
	
	void updateUom(Uom ob);

	List<Object[ ]> getUomTypeCount();

	List<Object[ ]> getUomIdAndModel();


}
