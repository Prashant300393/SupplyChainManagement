package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.Document;

public interface IDocumentDao {

	Integer saveDocument(Document doc);

	List<Object[ ]> getFileIdAndNames();
	
	Document getOneDocument(Integer id);
}
