package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.Part;

public interface IPartDao {

	Integer savePart(Part ob);

	List<Part> getAllParts();

	void deletePart(Integer id);
	
	Part getOnePart(Integer id);
	
	void updatePart(Part ob);
	
	List<Object[ ]> getPartIdAndCodes();
}
