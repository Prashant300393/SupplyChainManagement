package com.amdocs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IShipmentTypeDao;
import com.amdocs.model.ShipmentType;
import com.amdocs.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	// 4. Implement IService method in ServiceImpl using IShipmentDao Dependency
	@Autowired
	private IShipmentTypeDao dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {
		return dao.saveShipmentType(ob);
	}

	@Transactional(readOnly = true)	// SELECT OPERATION
	public List<ShipmentType> getAllShipmentTypes() {

		List<ShipmentType> list = dao.getAllShipmentTypes();

		//		Sorting data using Collections.sort(List<T>, Comparator) method
		//		Collections.sort(list, (o1,o2) -> o1.getShipId()-o2.getShipId() );        

		list = list.stream()
					  .sorted( (o1,o2) -> o1.getShipId()-o2.getShipId() )
					  .collect(Collectors.toList());

		return list;
	}

	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);
	}
	
	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentType(Integer id) {
		return dao.getOneShipmentType(id);
	}
	
	@Transactional
	public void updatShipmentType(ShipmentType ob) {
		
		dao.updatShipmentType(ob);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getShipmentModeCount() {
		return dao.getShipmentModeCount();
	}
	
	@Transactional(readOnly = true)
	public List<Object[ ]> getShipmentTypeIdAndCode() {
		return dao.getShipmentTypeIdAndCode();
	}
	
	@Transactional(readOnly = true)
	public boolean isShipmentCodeExsit(String shipCode) {
		return dao.isShipmentCodeExsit(shipCode);
	}
	
}
