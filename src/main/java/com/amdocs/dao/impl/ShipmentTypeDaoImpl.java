package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IShipmentTypeDao;
import com.amdocs.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	// 2. Implement IDao method in DaoImpl using HibernateTemplate
	@Autowired
	private HibernateTemplate ht;
	
	// Inserting Data From UI to Database
	@Override
	public Integer saveShipmentType(ShipmentType ob) {
		return (Integer) ht.save(ob);
	}
	
	// Fetching All Data From Table returns List<T>
	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}
	
	@Override
	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));
	}
	
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}
	
	@Override
	public void updatShipmentType(ShipmentType ob) {
		ht.update(ob);
	}

	
	// Bar Charts
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getShipmentModeCount() {
		String hql = " select shipMode, count(shipMode)  from com.amdocs.model.ShipmentType group by shipMode  ";
		return (List<Object[ ]>) ht.find(hql);
	}

	// Integeration ShipmentType with Other Module
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[ ]> getShipmentTypeIdAndCode() {
		String hql = " SELECT shipId, shipCode FROM " +ShipmentType.class.getName()+ " WHERE enbShip='YES' ";
		return (List<Object[]>) ht.find(hql);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean isShipmentCodeExsit(String shipCode) {
		boolean flag = false;
		String hql = " SELECT COUNT(shipCode) FROM " +ShipmentType.class.getName()+ " WHERE shipCode=?0 ";
		List<Long> list = (List<Long>) ht.find(hql, shipCode);
		if(list!=null && !list.isEmpty()) {
			long count = list.get(0);
			System.out.println(count);
			if(count==0)
				flag = false;	// DATA NOT EXIST
			else
				flag = true;	// DATA ALREADY EXIST
		}
		return flag;
	}
	
	
}//class
