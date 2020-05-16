package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IGrnDao;
import com.amdocs.model.Grn;

@Repository
public class GrnDaoImpl implements IGrnDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveGrn(Grn grn) {
		return (Integer)ht.save(grn);
	}

	@Override
	public void updateGrn(Grn grn) {
		ht.update(grn);
	}
	
	@Override
	public List<Grn> getAllGrns() {
		return ht.loadAll(Grn.class);
	}
	
	@Override
	public void deleteGrn(Integer id) {
		Grn grn = new Grn();
		grn.setId(id);
		ht.delete(grn);
	}
	
	
	@Override
	public Grn getOneGrn(Integer id) {
		return ht.get(Grn.class, id);
	}
	
	
	
}
