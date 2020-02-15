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
}
