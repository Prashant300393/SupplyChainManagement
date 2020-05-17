package com.amdocs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IGrnDao;
import com.amdocs.model.Grn;
import com.amdocs.model.GrnDtl;
import com.amdocs.service.IGrnService;

@Service
public class GrnServiceImpl implements IGrnService {

	@Autowired
	private IGrnDao dao;
	
	@Transactional
	public Integer saveGrn(Grn grn) {
		return dao.saveGrn(grn);
	}
	
	@Transactional
	public void updateGrn(Grn grn) {
		dao.updateGrn(grn);
	}
	
	@Transactional(readOnly = true)
	public List<Grn> getAllGrns() {
		return dao.getAllGrns();
	}
	
	@Transactional
	public void deleteGrn(Integer id) {
		dao.deleteGrn(id);
	}
	
	@Transactional(readOnly = true)
	public Grn getOneGrn(Integer id) {
		return dao.getOneGrn(id);
	}
	
	@Override
	@Transactional
	public Integer saveGrnDtl(GrnDtl dtl) {
		return dao.saveGrnDtl(dtl);
	}
	
}
