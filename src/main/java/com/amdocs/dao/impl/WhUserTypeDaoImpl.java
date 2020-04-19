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
	
	/**
	 * 		ht.find() always returns List<?> whether it is One value or multiple
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean isUserCodeExist(String userCode) {
		boolean flag = false;
		// SQL	: "SELECT COUNT(USERCODE) FROM WHUSERTAB WHERE USERCODE=?"
		String hql = " select count(userCode) from "+WhUserType.class.getName()+" where userCode=?0 ";
		List<Long> list = (List<Long>) ht.find(hql, userCode);
		if(list!=null && !list.isEmpty()) {
			long count = list.get(0);
			if(count==0)
				flag=false; // DATA not Exist
			else
				flag = true; // DATA already Exist
		}
		return flag;
	}
	
	/**
	 * 		ht.find() always returns List<?> whether it is One value or multiple
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean isUserMailExist(String userMail) {
		boolean flag = false;
		// SQL	: "SELECT COUNT(USERMAIL) FROM WHUSERTAB WHERE USERMAIL=?"
		String hql = " select count(userMail) from "+WhUserType.class.getName()+	" where userMail=?0 ";
		List<Long> list = (List<Long>)ht.find(hql, userMail);
		// read the value if LIST IS NOT EMPTY OR NULL from index(0) which returns COUNT
		if(list!=null && !list.isEmpty()) {
			long count = list.get(0);
			if(count==0)
				flag = false;		// DATA NOT EXIST
			else
				flag = true;		// DATA ALREADY EXIST
		}
		return flag;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean isUserContactExist(String userContact) {
		boolean flag = false;
		//SQL : select count(userContact) from whusertab where userContact=?
		String hql = "select count(userContact) from " +WhUserType.class.getName()+" where userContact=?0 ";
		List<Long> list = (List<Long>)ht.find(hql, userContact);
		// read the value if LIST IS NOT EMPTY OR NULL from index(0) which returns COUNT
		if(list!=null && !list.isEmpty()) {
			long count = list.get(0);
			if(count==0)
				flag = false;		// DATA NOT EXIST
			else
				flag = true;		// DATA ALREADY EXIST
		}
		return flag;
	}

	
	
}
