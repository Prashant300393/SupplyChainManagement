package com.amdocs.service;

import java.util.List;

import com.amdocs.model.Uom;

public interface IUomService {

	Integer saveUom(Uom ob);
	
	List<Uom> getAllUoms();
	
	void deleteUom(Integer id);
	
	Uom getOneUom(Integer id);
	
	void updateUom(Uom ob);
}