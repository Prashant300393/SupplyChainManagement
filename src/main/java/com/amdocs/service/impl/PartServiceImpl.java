package com.amdocs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IPartDao;
import com.amdocs.model.Part;
import com.amdocs.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private IPartDao dao;
	
	@Transactional
	public Integer savePart(Part ob) {
		return dao.savePart(ob);
	}

	@Transactional(readOnly = true)
	public List<Part> getAllParts() {
		List<Part> list = dao.getAllParts();
		list = list.stream()
					 .sorted((o1, o2)-> o1.getPartId()-o2.getPartId())
					 .collect(Collectors.toList());
		return list;
	}

	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);
	}
	
	@Transactional(readOnly = true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}
	
	@Transactional
	public void updatePart(Part ob) {
		dao.updatePart(ob);
	}
	
}
