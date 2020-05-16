package com.amdocs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.dao.IPurchaseOrderDao;
import com.amdocs.model.PurchaseDtl;
import com.amdocs.model.PurchaseOrder;
import com.amdocs.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;

	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return dao.savePurchaseOrder(po);
	}

	@Transactional(readOnly = true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> list = dao.getAllPurchaseOrders();
		list = list.stream()
				.sorted( (o1, o2) -> o1.getId()-o2.getId())
				.collect(Collectors.toList());
		return list;
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {

		dao.deletePurchaseOrder(id);
	}

	@Transactional(readOnly = true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return dao.getOnePurchaseOrder(id);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {
		dao.updatePurchaseOrder(po);
	}

	// Purchase Detail
	@Transactional
	public Integer savePurchaseDtl(PurchaseDtl dtl) {
		return dao.savePurchaseDtl(dtl);
	}

	// Purchase Detail
	@Transactional
	public void deletePurchaseDtl(Integer id) {
		dao.deletePurchaseDtl(id);
	}

	@Transactional
	public void updatePoStatus(Integer poId, String status) {
		dao.updatePoStatus(poId, status);
	}





}
