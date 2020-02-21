package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IWhUserTypeDao;
import com.amdocs.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;

	//INSERTING
	@Override
	public Integer saveWhUserType(WhUserType ob) {
		return (Integer)ht.save(ob);
	}
	
	// FETCHING DATA FROM DATABASE TO UI
	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}
	
	// DELETING RECORD FROM DATABASE
	@Override
	public void deleteWhUserType(Integer id) {
		
		ht.delete(new WhUserType(id));
	}
}