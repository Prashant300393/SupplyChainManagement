package com.amdocs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IDocumentDao;
import com.amdocs.model.Document;
import com.amdocs.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao dao;
	
	@Transactional
	public Integer saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}
	
	@Override
	public Document getOneDocument(Integer id) {
		return dao.getOneDocument(id);
	}
	
	
}
