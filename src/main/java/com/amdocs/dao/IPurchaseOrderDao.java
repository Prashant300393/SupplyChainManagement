package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.PurchaseOrder;

public interface IPurchaseOrderDao {

	Integer savePurchaseOrder(PurchaseOrder po);

	List<PurchaseOrder> getAllPurchaseOrders();

	void deletePurchaseOrder(Integer id);
	
	PurchaseOrder getOnePurchaseOrder(Integer id);

	void updatePurchaseOrder(PurchaseOrder po);
}
