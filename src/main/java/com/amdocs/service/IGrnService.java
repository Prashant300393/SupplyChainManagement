package com.amdocs.service;

import java.util.List;

import com.amdocs.model.Grn;

public interface IGrnService {

	Integer saveGrn(Grn grn);
	
	void updateGrn(Grn grn);
	
	List<Grn> getAllGrns();
	
	void deleteGrn(Integer id);
	
	Grn getOneGrn(Integer id);
	
	
}
