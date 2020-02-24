package com.amdocs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.model.OrderMethod;
import com.amdocs.service.IOrderMethodService;
import com.amdocs.view.OrderMethodExcelView;
import com.amdocs.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	/**
	 * 	1. Show "OrderMethodRegister.jsp"	
	 * 		URL : "/register" : GET , METHOD : showRegPage()
	 */

	@RequestMapping("/register")
	public String showRegPage(Model model)
	{
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	/**
	 * 	2. On Click "Create" , Read Form Data using @ModelAttribute and SAVE in the DATABASE
	 * 		URL : /save : POST , METHOD : saveOrderMethod()
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model			
			) 
	{
		Integer id = service.saveOrderMethod(orderMethod);
		String msg = "OrderMethod  ' "+id+" ' Saved ";
		model.addAttribute("msg", msg);
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	/**
	 * 3.	FETCH all the DATA from DATABASE and Display on UI as HTML TABLE
	 * 		URL : "/all" : GET  , METHOD : getAllOrderMetods()
	 */

	@RequestMapping("/all") // GET
	public String showOrderData(Model model)
	{
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

	/**
	 * 4. DELETE a ROW from TABLE, on Click HYPERLINK "/delete?oid=_"	
	 * 		URL : "/delete"	: GET , METHOD :	 deleteOrderMethod()
	 * 		Read the "oid" using @RequestParam("key") DataType LocalVar
	 */

	@RequestMapping("/delete")
	public String deleteOrderMethod( 
			@RequestParam("oid")Integer id,
			Model model
			)
	{
		service.deleteOrderMethod(id);
		String msg = "OrderMethod ' "+id+" ' Deleted  ";
		model.addAttribute("msg", msg);
		// fetch the new Data
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

	/**
	 *  5. On Click HYPERLINK "EDIT" , Display SELECTED DATA ON "OrderMethodEdit.jsp" Page,
	 *  	Using "FormBackingObject"  and @RequestParam
	 *  	URL : "/edit : GET , METHOD : showEditPage() 
	 */

	@RequestMapping("/edit")  // GET
	public String showEditPage(
			@RequestParam("oid") Integer id,
			Model model
			)
	{
		OrderMethod om = service.getOneOrderMethod(id);
		model.addAttribute("orderMethod", om);

		return "OrderMethodEdit";
	}

	/**
	 *  6. On Click "UPDATE" on "OrderMethodEdit.jsp"	, Data will be Updated in DB
	 *   	 Using @ModelAttribute and Display the NEW DATA ON "OrderMethodData.jsp	"
	 *   	URL : /update : POST ,  METHOD : updateOrderMethod()
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model
			)
	{
		service.updateOrderMethod(orderMethod);
		String msg = "OrderMethod ' "+orderMethod.getOrderId()+" ' Updated  ";
		model.addAttribute("msg", msg);
		// FETCH the NEW DATA 
		List<OrderMethod> list = service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

	/**
	 *  7.  On click "VIEW" HYPERLINK, Display One Row as HTML Table on UI
	 */

	@RequestMapping("/view")
	public String viewOneOrderMethod(
			@RequestParam("oid")Integer id,
			Model model
			)
	{
		OrderMethod om = service.getOneOrderMethod(id);
		model.addAttribute("om", om);

		return "OrderMethodView";
	}

	/**
	 * 	8. On Click "EXCEL EXPORT" , Data should be Converted to ExcelFile and Download
	 * 		Use "ModelAndView"	class which Holds both Model(DATA) and View(Page) as a Single Unit
	 */

	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id", required = false)Integer id
			)
	{
		ModelAndView m = new ModelAndView();
		m.setView(new OrderMethodExcelView());

		if(id==null)
		{
			List<OrderMethod> list = service.getAllOrderMethods();
			m.addObject("list", list);
		}
		else
		{
			OrderMethod om = service.getOneOrderMethod(id);
			m.addObject("list", Arrays.asList(om));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id", required = false)Integer id
			)
	{
		ModelAndView m= new ModelAndView();
		m.setView(new OrderMethodPdfView());
		if(id==null)
		{
			List<OrderMethod> list = service.getAllOrderMethods();
			m.addObject("list", list);
		}
		else
		{
			OrderMethod om = service.getOneOrderMethod(id);
			m.addObject("list", Arrays.asList(om));
		}
		return m;
	}

}
