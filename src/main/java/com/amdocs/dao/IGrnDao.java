package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.Grn;

public interface IGrnDao {
	
	Integer saveGrn(Grn grn);
	
	void updateGrn(Grn grn);
	
	List<Grn> getAllGrns();
	
	void deleteGrn(Integer id);
	
	Grn getOneGrn(Integer id);
	
	
	
}
