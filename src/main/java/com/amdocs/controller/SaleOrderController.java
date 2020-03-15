package com.amdocs.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.amdocs.model.SaleOrder;
import com.amdocs.service.ISaleOrderService;
import com.amdocs.service.IShipmentTypeService;
import com.amdocs.service.IWhUserTypeService;
import com.amdocs.util.CommonUtil;
import com.amdocs.view.SaleOrderExcelView;
import com.amdocs.view.SaleOrderPdfView;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {

	@Autowired
	private ISaleOrderService service;
	
	@Autowired
	private IShipmentTypeService shipTypeService;
	
	@Autowired
	private IWhUserTypeService whUserTypeService;
	
	// Common Logic method for Setting the FormBacking Object
	public void resetForm(Model model) {
		SaleOrder sale = new SaleOrder();
		sale.setStatus("SALE-OPEN");
		model.addAttribute("saleOrder", sale);	
	}
	
	/** (Register / Edit)
	 * Its will Display the DropDown at UI for "ShipmentType Code" and "WhUserType Code" 
	 * and its Logic to get "id" and "code" based on the where condition
	 */
	private void commonUi(Model model) {
		// ShipmentTypeService
		List<Object[ ]> shipList = shipTypeService.getShipmentTypeIdAndCode();
		Map<Integer, String> shipMap = CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);
		
		// WhUserType where UserType = Customer
		List<Object[ ]> whList = whUserTypeService.getWhUserTypeIdAndCode("Customer");
		Map<Integer, String> whMap = CommonUtil.convert(whList);
		model.addAttribute("whMap", whMap);
	}

	// 1. Register Page
	@RequestMapping("/register")
	public String showRegPage(Model model	) 
	{
		resetForm(model);
		commonUi(model);
		return "SaleOrderRegister";
	}

	@RequestMapping(value = "/save", method = POST)
	public String saveSaleOrder(
			@ModelAttribute SaleOrder saleOrder,
			Model model
			)
	{
		Integer id = service.saveSaleOrder(saleOrder);
		model.addAttribute("msg", id+"- saved");
		// To get Back the DropDowns and Form Reset
		commonUi(model);
		resetForm(model);
		return "SaleOrderRegister";
	}

	@RequestMapping("/all")
	public String  getAllSaleOrders(Model model) {
		
		List<SaleOrder> list = service.getAllSaleOrders();
		model.addAttribute("list", list);
		return "SaleOrderData";
	}
	
	@RequestMapping("/delete")
	public String deleteSaleOrder(
			@RequestParam("id") Integer id,
			Model model
			)
	{
		service.deleteSaleOrder(id);
		String msg = "SaleOrder"+id+ "Deleted";
		model.addAttribute("msg", msg);
		List<SaleOrder> list = service.getAllSaleOrders();
		model.addAttribute("list", list);
		return "SaleOrderData";
	}
		
	@RequestMapping("/view")	// GET
	public String viewOneSaleOrder( 
			@RequestParam("id")Integer id,
			Model model		
			)
	{
		SaleOrder so = service.getOneSaleOrder(id);
		model.addAttribute("ob", so);
		return "SaleOrderView";
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
		SaleOrder so= service.getOneSaleOrder(id);
		model.addAttribute("saleOrder", so);

		commonUi(model);
		return "SaleOrderEdit";
	}
	
	/**
	 * Update
	 */
	@RequestMapping(value = "/update", method = POST)
	public String updateSaleOrder(
			@ModelAttribute SaleOrder SaleOrder, 
			Model model
			) 
	{
		service.updateSaleOrder(SaleOrder);
		model.addAttribute("msg", SaleOrder.getSaleId()+" - Updated");
		List<SaleOrder> list = service.getAllSaleOrders();
		model.addAttribute("list", list);
		return "SaleOrderData";
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
			List<SaleOrder> list = service.getAllSaleOrders();
			m.addObject("list", list);
		}
		else {
			SaleOrder so = service.getOneSaleOrder(id);
			List<SaleOrder> list = Arrays.asList(so);
			m.addObject("list", list);
		}
		m.setView(new SaleOrderExcelView());
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
			List<SaleOrder> list = service.getAllSaleOrders();
			m.addObject("list", list);
		}
		else {
			SaleOrder so = service.getOneSaleOrder(id);
			List<SaleOrder> list = Arrays.asList(so);
			m.addObject("list", list);
		}
		m.setView(new SaleOrderPdfView());
		return m;
	}


}
