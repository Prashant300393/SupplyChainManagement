package com.amdocs.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.dao.ISaleOrderDao;
import com.amdocs.model.SaleOrder;
import com.amdocs.service.ISaleOrderService;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService {

	@Autowired
	private ISaleOrderDao dao;

	@Transactional
	public Integer saveSaleOrder(SaleOrder so) {
		return dao.saveSaleOrder(so);
	}

	@Transactional(readOnly = true)
	public List<SaleOrder> getAllSaleOrders() {
		List<SaleOrder> list = dao.getAllSaleOrders();
		list = list.stream()
					  .sorted( (o1, o2) -> o1.getSaleId()-o2.getSaleId())
					  .collect(Collectors.toList());
		return list;
	}
	
	@Transactional
	public void deleteSaleOrder(Integer id) {
		
		dao.deleteSaleOrder(id);
	}
	
	@Transactional(readOnly = true)
	public SaleOrder getOneSaleOrder(Integer id) {
		return dao.getOneSaleOrder(id);
	}
	
	@Transactional
	public void updateSaleOrder(SaleOrder po) {
		
		dao.updateSaleOrder(po);
	}



}
