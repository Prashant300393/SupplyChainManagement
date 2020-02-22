package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IUomDao;
import com.amdocs.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUom(Uom ob) {
		return (Integer) ht.save(ob);
	}
	
	@Override
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}
	
	@Override
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}
	
	@Override
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class, id);
	}
	
	@Override
	public void updateUom(Uom ob) {
		ht.update(ob);
	}
	
}
