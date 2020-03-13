package com.amdocs.service;

import java.util.List;

import com.amdocs.model.PurchaseOrder;

public interface IPurchaseOrderService {

	Integer savePurchaseOrder(PurchaseOrder po);

	List<PurchaseOrder> getAllPurchaseOrders();
	
	void deletePurchaseOrder(Integer id);
	
	PurchaseOrder getOnePurchaseOrder(Integer id);
}
