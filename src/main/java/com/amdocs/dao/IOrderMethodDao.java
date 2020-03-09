package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.OrderMethod;

public interface IOrderMethodDao {

	Integer saveOrderMethod(OrderMethod ob);

	List<OrderMethod> getAllOrderMethods();

	void deleteOrderMethod(Integer id);
	
	OrderMethod getOneOrderMethod(Integer id);
	
	void updateOrderMethod(OrderMethod ob);

	List<Object[ ]> getOrderModeCount();
	
	List<Object[ ]> getOrderMethodIdAndMode();
	
}
