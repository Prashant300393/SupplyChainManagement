package com.amdocs.service;

import java.util.List;

import com.amdocs.model.PurchaseDtl;
import com.amdocs.model.PurchaseOrder;

public interface IPurchaseOrderService {

	Integer savePurchaseOrder(PurchaseOrder po);

	List<PurchaseOrder> getAllPurchaseOrders();
	
	void deletePurchaseOrder(Integer id);
	
	PurchaseOrder getOnePurchaseOrder(Integer id);

	void updatePurchaseOrder(PurchaseOrder po);

	public Integer savePurchaseDtl(PurchaseDtl dtl);

	void deletePurchaseDtl(Integer id);
	
	public void updatePoStatus(Integer poId, String status);

}

