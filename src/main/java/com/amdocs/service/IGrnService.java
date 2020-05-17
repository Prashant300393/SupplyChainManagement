package com.amdocs.service;

import java.util.List;

import com.amdocs.model.Grn;
import com.amdocs.model.GrnDtl;

public interface IGrnService {

	Integer saveGrn(Grn grn);
	
	void updateGrn(Grn grn);
	
	List<Grn> getAllGrns();
	
	void deleteGrn(Integer id);
	
	Grn getOneGrn(Integer id);
	
	Integer saveGrnDtl(GrnDtl dtl	);
	
}
