package com.amdocs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IWhUserTypeDao;
import com.amdocs.model.WhUserType;
import com.amdocs.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	
	@Transactional
	public Integer saveWhUserType(WhUserType ob) {
			
			return dao.saveWhUserType(ob);
}

	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUserTypes() {
		
		List<WhUserType>list = dao.getAllWhUserTypes();
		list = list.stream()
					  .sorted( (o1, o2) -> o1.getUserId()-o2.getUserId() )
					  .collect(Collectors.toList());
		return list;
	}
	
	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}
	
	@Transactional(readOnly = true)
	public WhUserType getOneWhUserType(Integer id) {
		return dao.getOneWhUserType(id);
	}
	
	@Transactional
	public void updateWhUserType(WhUserType ob) {
		dao.updateWhUserType(ob);
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getWhUserTypeCount() {
		return dao.getWhUserTypeCount();
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getWhUserTypeIdAndCode(String userType) {
		return dao.getWhUserTypeIdAndCode(userType);
	}




}
