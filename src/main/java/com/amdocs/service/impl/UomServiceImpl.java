package com.amdocs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IUomDao;
import com.amdocs.model.Uom;
import com.amdocs.service.IUomService;

@Service
public class UomServiceImpl implements IUomService{

	@Autowired
	private IUomDao dao;

	@Transactional
	public Integer saveUom(Uom ob) {
		return dao.saveUom(ob);
	}

	@Transactional(readOnly = true)
	public List<Uom> getAllUoms() {
		List<Uom> list = dao.getAllUoms();
//		Collections.sort(list, (o1,o2) -> o1.getUomId()-o2.getUomId());

		// Sorting 
		list = list.stream()
					  .sorted( (o1, o2) -> o1.getUomId()-o2.getUomId()  )
					  .collect(Collectors.toList());
		return list;
	}
	
	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}
	
	@Transactional(readOnly = true)
	public Uom getOneUom(Integer id) {
		return dao.getOneUom(id);
	}
	
	@Transactional
	public void updateUom(Uom ob) {
		dao.updateUom(ob);
	}
}