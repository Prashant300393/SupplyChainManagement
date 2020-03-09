package com.amdocs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.IOrderMethodDao;
import com.amdocs.model.OrderMethod;
import com.amdocs.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {
		return dao.saveOrderMethod(ob);
	}

	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {
		List<OrderMethod> list = dao.getAllOrderMethods();
		list = list.stream()
					 .sorted((o1, o2)-> o1.getOrderId()-o2.getOrderId()  )
					 .collect(Collectors.toList());
		return list;
	}

	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}
	
	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}
	
	@Transactional
	public void updateOrderMethod(OrderMethod ob) {
		dao.updateOrderMethod(ob);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getOrderModeCount() {
		return dao.getOrderModeCount();
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodIdAndMode() {
		return dao.getOrderMethodIdAndMode();
	}
	
	
	
	
	
}
