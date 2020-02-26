package com.amdocs.service;

import java.util.List;

import com.amdocs.model.Document;

public interface IDocumentService {

	Integer saveDocument(Document doc);

	List<Object[ ]> getFileIdAndNames();
	
	Document getOneDocument(Integer id);
	
}
