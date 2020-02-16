package com.amdocs.service;

import java.util.List;

import com.amdocs.model.WhUserType;

public interface IWhUserTypeService {

	Integer saveWhUserType(WhUserType ob);
	
	List<WhUserType> getAllWhUserTypes();
	
	void deleteWhUserType(Integer id);
}
