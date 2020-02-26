package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IDocumentDao;
import com.amdocs.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getFileIdAndNames() {
		String hql = "SELECT fileId, fileName FROM com.amdocs.model.Document	";
		return (List<Object[ ]>) ht.find(hql);
	}
	
	@Override
	public Document getOneDocument(Integer id) {
		return ht.get(Document.class, id);
	}
	
	
	
	
	
	
}
