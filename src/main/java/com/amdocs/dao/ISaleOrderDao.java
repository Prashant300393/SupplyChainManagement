package com.amdocs.dao;


import java.util.List;

import com.amdocs.model.SaleOrder;

public interface ISaleOrderDao {

	Integer saveSaleOrder(SaleOrder so);
		
	List<SaleOrder> getAllSaleOrders();

	void deleteSaleOrder(Integer id);
	
	SaleOrder getOneSaleOrder(Integer id);

	void updateSaleOrder(SaleOrder so);
	
}
