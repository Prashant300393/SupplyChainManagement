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
		WhUserType wh = new WhUserType();
		wh.setUserId(id);
		ht.delete(wh);
	}
	
	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	@Override
	public void updateWhUserType(WhUserType ob) {
		ht.update(ob);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getWhUserTypeCount() {
		String hql = " select userType, count(userType) from com.amdocs.model.WhUserType group by userType ";
		return (List<Object[ ]>) ht.find(hql);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhUserTypeIdAndCode(String userType) {
		String hql = " select userId, userCode from "  +WhUserType.class.getName()+  " where userType=?0  ";
		return (List<Object[ ]>)ht.find(hql, userType);
	}

}
