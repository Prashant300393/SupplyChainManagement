package com.amdocs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.amdocs.dao.IPurchaseOrderDao;
import com.amdocs.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return (Integer) ht.save(po);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return ht.loadAll(PurchaseOrder.class);
	}
	
	@Override
	public void deletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}
	
}
