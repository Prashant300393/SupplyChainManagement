package com.amdocs.service;

import java.util.List;

import com.amdocs.model.WhUserType;

public interface IWhUserTypeService {

	Integer saveWhUserType(WhUserType ob);
	
	List<WhUserType> getAllWhUserTypes();
	
	void deleteWhUserType(Integer id);
	
	WhUserType getOneWhUserType(Integer id);

	void updateWhUserType(WhUserType ob);

	List<Object[ ]> getWhUserTypeCount();

	List<Object[ ]> getWhUserTypeIdAndCode(String userType);
	
	// SERVER SIDE VALIDATION METHODS 
	boolean isUserCodeExist(String userCode);
	
	boolean isUserMailExist(String userMail);
	
	boolean isUserContactExist(String userContact);
	
	
}
