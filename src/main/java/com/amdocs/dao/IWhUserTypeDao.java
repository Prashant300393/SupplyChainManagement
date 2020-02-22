package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.WhUserType;

public interface IWhUserTypeDao {

	Integer saveWhUserType(WhUserType ob);
	
	List<WhUserType> getAllWhUserTypes();
	
	void deleteWhUserType(Integer id);
	
	WhUserType getOneWhUserType(Integer id);

	void updateWhUserType(WhUserType ob);
}
