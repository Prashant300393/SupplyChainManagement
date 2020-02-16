package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.Uom;

public interface IUomDao {
	
	// INSERTING DATA : Serializable (PrimaryKey) , we have to DownCast to Integer
	Integer saveUom(Uom ob);
	
	// FETCHING DATA FROM DATABASE
	List<Uom> getAllUoms();

	void deleteUom(Integer id);
}
