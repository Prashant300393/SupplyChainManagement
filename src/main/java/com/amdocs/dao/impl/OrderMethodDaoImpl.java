package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IOrderMethodDao;
import com.amdocs.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrderMethod(OrderMethod ob) {
		return (Integer)ht.save(ob);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}
	
	@Override
	public void deleteOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}
	
	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class, id);
	}
	
	@Override
	public void updateOrderMethod(OrderMethod ob) {
		ht.update(ob);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getOrderModeCount() {
		String hql = " select orderMode, count(orderMode) from com.amdocs.model.OrderMethod group by orderMode ";
		return (List<Object[]>) ht.find(hql);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getOrderMethodIdAndMode() {
		String hql = " select orderId, orderMode from com.amdocs.model.OrderMethod ";
		return (List<Object[]>) ht.find(hql);
	}
	
	
	
	
	
}
