package com.amdocs.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.amdocs.model.PurchaseDtl;
import com.amdocs.model.PurchaseOrder;
import com.amdocs.service.IPartService;
import com.amdocs.service.IPurchaseOrderService;
import com.amdocs.service.IShipmentTypeService;
import com.amdocs.service.IWhUserTypeService;
import com.amdocs.util.CommonUtil;
import com.amdocs.view.PurchaseOrderExcelView;
import com.amdocs.view.PurchaseOrderPdfView;
import com.amdocs.view.VendorInvoicePdf;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {

	@Autowired
	private IPartService partService;

	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipmentTypeService; // ShipmentType

	@Autowired
	private IWhUserTypeService whUserTypeService;	// WhUserType


	// Common Logic method for Setting the FormBacking Object
	private void resetForm(Model model) {
		PurchaseOrder po = new PurchaseOrder();
		po.setPoStatus("OPEN");
		model.addAttribute("purchaseOrder", po);
	}

	/** (Register / Edit)
	 * Its will Display the DropDown at UI for "ShipmentType Code" and "WhUserType Code" 
	 * and its Logic to get "id" and "code" based on the where condition
	 */
	private void commonUi(Model model) {
		// ShipmentType Code Dropdown integeration
		List<Object[ ]> shipList = shipmentTypeService.getShipmentTypeIdAndCode();
		Map<Integer, String> shipMap = CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);

		//WhUserType Code based on Vendor Dropdown integration
		List<Object[ ]> whList = whUserTypeService.getWhUserTypeIdAndCode("Vendor");
		Map<Integer, String> whMap = CommonUtil.convert(whList);
		model.addAttribute("whMap", whMap);

	}

	// 1. Register method
	@RequestMapping("/register")
	public String showRegPage(Model model)
	{
		commonUi(model);
		resetForm(model);
		return "PurchaseOrderRegister";
	}

	// 2. Save Purchase Order
	@RequestMapping(value = "/save", method = POST)
	public String savePurchaseOrder( 
			@ModelAttribute PurchaseOrder purchaseOrder,
			Model model
			)
	{
		Integer id = service.savePurchaseOrder(purchaseOrder);
		model.addAttribute("msg", id+" saved");
		commonUi(model);
		resetForm(model);
		return "PurchaseOrderRegister";
	}

	@RequestMapping("/all")
	public String  getAllPurchaseOrders(Model model) {

		List<PurchaseOrder> list = service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}

	@RequestMapping("/delete")
	public String deletePurchaseOrder(
			@RequestParam("id") Integer id,
			Model model
			)
	{
		service.deletePurchaseOrder(id);
		String msg = "PurchaseOrder"+id+ "Deleted";
		model.addAttribute("msg", msg);
		List<PurchaseOrder> list = service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}

	@RequestMapping("/view")	// GET
	public String viewOnePurchaseOrder( 
			@RequestParam("id")Integer id,
			Model model		
			)
	{
		PurchaseOrder po = service.getOnePurchaseOrder(id);
		model.addAttribute("ob", po);
		return "PurchaseOrderView";
	}	

	/**
	 *  Edit 
	 */
	@RequestMapping("/edit")
	public String editPage(
			@RequestParam("id") Integer id,
			Model model
			) 
	{
		PurchaseOrder po = service.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder", po);

		commonUi(model);
		return "PurchaseOrderEdit";
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "/update", method = POST)
	public String updatePurchaseOrder(
			@ModelAttribute PurchaseOrder purchaseOrder, 
			Model model
			) 
	{
		service.updatePurchaseOrder(purchaseOrder);
		model.addAttribute("msg", purchaseOrder.getId()+" - Updated");
		List<PurchaseOrder> list = service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
		//		return "redirect:all";
	}

	/**
	 * Excel
	 */
	@RequestMapping("/excel")
	public ModelAndView excelView(
			@RequestParam(value = "id", required = false) Integer id
			) 
	{
		ModelAndView m = new ModelAndView();

		if(id==null) {
			List<PurchaseOrder> list = service.getAllPurchaseOrders();
			m.addObject("list", list);
		}
		else {
			PurchaseOrder po = service.getOnePurchaseOrder(id);
			List<PurchaseOrder> list = Arrays.asList(po);
			m.addObject("list", list);
		}
		m.setView(new PurchaseOrderExcelView());
		return m;
	}

	/**
	 *  Pdf
	 */

	@RequestMapping("/pdf")
	public ModelAndView pdfView(
			@RequestParam(value = "id", required = false) Integer id
			) 
	{
		ModelAndView m = new ModelAndView();
		if(id==null) {
			List<PurchaseOrder> list = service.getAllPurchaseOrders();
			m.addObject("list", list);
		}
		else {
			PurchaseOrder po = service.getOnePurchaseOrder(id);
			List<PurchaseOrder> list = Arrays.asList(po	);
			m.addObject("list", list);
		}
		m.setView(new PurchaseOrderPdfView());
		return m;
	}

	/*******************SCREEN #2******************************/

	@RequestMapping("/parts")
	public String showPurchaseDtl(
			@RequestParam("poId") Integer poId,
			Model model
			)
	{
		// get Purchase Order Data
		PurchaseOrder pOrder = service.getOnePurchaseOrder(poId);
		model.addAttribute("pOrder", pOrder);

		// form Backing object
		model.addAttribute("purchaseDtl", new PurchaseDtl()	);

		// DropDown Data
		List<Object[ ]> partsList = partService.getPartIdAndCodes();
		Map<Integer, String> partsMap = CommonUtil.convert(partsList);
		model.addAttribute("partsMap", partsMap);

		// Display All Parts which are added for this PO
		List<PurchaseDtl> childDtl = pOrder.getChildDtl();

		// serialNo setting..generated at runtime
		int i = 1;
		for(PurchaseDtl dtl : childDtl) {
			dtl.setSlNo(i++);
		}
		model.addAttribute("childDtl", childDtl);

		return "PurchaseParts";
	}

	// adding/save(Part) the Purchase Detail
	@RequestMapping(value = "/addPart", method = RequestMethod.POST)
	public String addPart(
			@ModelAttribute PurchaseDtl purchaseDtl
			) 
	{
		service.savePurchaseDtl(purchaseDtl);
		Integer poId = purchaseDtl.getPo().getId();

		//Atleast one Part is added then [STATUS : PICKING]
		service.updatePoStatus(poId, "PICKING");

		return "redirect:parts?poId="+poId;
	}

	// Deleting the Part
	@RequestMapping("/removePart")
	public String deletePart(
			@RequestParam("dtlId")Integer dtlId,
			@RequestParam("poId")Integer poId			
			) 
	{
		service.deletePurchaseDtl(dtlId);
		// When No Part is added or existing is removed [ STATUS : OPEN ] 
		if(service.getOnePurchaseOrder(poId).getChildDtl().isEmpty()) {
			service.updatePoStatus(poId, "OPEN");
		}

		return "redirect:parts?poId="+poId;
	}

	// ON CLICK CONFIRM ORDER
	@RequestMapping("/placeorder")
	public String placeOrderConfirm(
			@RequestParam("poId")Integer poId
			)
	{
		service.updatePoStatus(poId, "ORDERED");

		return "redirect:parts?poId="+poId;	
	}

	// ON CLICK GENERATE INVOICE
	@RequestMapping("/invoiceOrder")
	public String invoiceOrder(
			@RequestParam("poId")Integer poId
			)
	{
		service.updatePoStatus(poId, "INVOICED");
		return "redirect:all";	
	}
	
	/*--------------------------------GENERATE DOWNLOAD PDF-------------------------------------	 */
	@RequestMapping("/downloadInvoice")
	public ModelAndView downloadInvoice(
			@RequestParam("poId")Integer poId
			)
	{
		ModelAndView m = new ModelAndView();
		
		PurchaseOrder po = service.getOnePurchaseOrder(poId);
		
		m.addObject("po", po);
		m.setView(new VendorInvoicePdf());
		
		return m;
	}

	


}//controller
