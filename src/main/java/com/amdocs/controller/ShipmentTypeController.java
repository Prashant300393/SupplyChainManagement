package com.amdocs.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.model.ShipmentType;
import com.amdocs.service.IShipmentTypeService;
import com.amdocs.util.ShipmentTypeUtil;
import com.amdocs.view.ShipmentTypeExcelView;
import com.amdocs.view.ShipmentTypePdfView;;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	/**
	 * 1. This method is used to Display "ShipmentTypeRegister Page"
	 * 		URL : "/register" , TYPE : GET
	 */

	@RequestMapping("/register")	// GET
	public String showRegPage(Model model)
	{
		model.addAttribute("shipmentType"	, new ShipmentType()	);
		return "ShipmentTypeRegister";
	}

	/**
	 *  2. On click SUBMIT "REGISTER FORM" 
	 * 		Read DATA from UI to CONTROLLER  using @ModelAttrubute <ClsName> <obName>
	 * 		Display "Success Message" on Same Page using "Model interface"
	 * 
	 * 		URL : "/save"	, TYPE : POST
	 */

	@RequestMapping(value = "/save", method = POST)
	public String saveShipment(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			)
	{
		Integer id = service.saveShipmentType(shipmentType);
		String message = "Shipment Type ' "+id+ " '  Saved";
		model.addAttribute("msg", message);

		model.addAttribute("shipmentType"	, new ShipmentType()	);	// clean the Data from the UI Form, otherwise it will be displayed on UI FORM

		return "ShipmentTypeRegister";
	}

	/**	 3.
	 * 		a) Fetch the DATA from DATABASE and DISPLAY on UI in HTML TABLE FORMAT
	 * 		b) Showing DATA from CONTROLLER TO UI :: MODEL (interface, memory provided by CONTAINER)
	 * 
	 *		c) URL : "/all"  ,  TYPE : GET  , PAGE : "ShipmentTypeData.jsp"
	 */

	@RequestMapping("/all")	// GET
	public String getAllShipmentTypes(Model model)
	{
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/**
	 *  4.  Deleting or editing one Row using URL Rewriting (Static path & Dynamic Path)
	 * 		  ===>REQUEST : delete?sid=10
	 *  
	 *   	read the Key using @RequestParam and display on UI using  Model
	 *   	URL : /delete , TYPE : GET , method = deleteShipment()
	 */

	@RequestMapping("/delete")
	public String deleteShipment(
			@RequestParam("sid")Integer id,
			Model model
			)
	{
		service.deleteShipmentType(id);
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		String msg = "Shipment  ' "+id+" '    Deleted";
		model.addAttribute("msg", msg);
		return "ShipmentTypeData";
	}	

	/**
	 * 5.  Creating EDIT hyperlink in "ShipmentTypeData.jsp"
	 * 		URL : "/edit , GET	, Method : showEditPage()
	 * 		Read the ID using @RequestParam
	 * 		Return to "ShipmentTypeEdit" Page
	 */

	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("sid")Integer id,
			Model model
			)
	{
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}

	/**
	 *  6. On click UPDATE , Data Read using @ModelAttribute
	 *  	URL : /update "POST"	, METHOD : updateShipmentType()
	 *  	Return "ShipmentTypeData.jsp"	Success Msg
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipment(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			)
	{
		service.updatShipmentType(shipmentType);
		// sending Success message to UI
		String msg = "Shipment ' "+shipmentType.getShipId()+" '  Updated";
		model.addAttribute("msg", msg);

		// FETCHING new DATA 
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/**
	 * 7.  On click VIEW Hyperlink , One Row Data Displayed on "ShipmentTypeView.jsp"
	 *  	URL : /view : GET , METHOD : showOneShipment()
	 *  	Read key using @RequestParam and send Data using Model
	 */

	@RequestMapping("/view")	// GET
	public String viewOneShipment( 
			@RequestParam("sid")Integer id,
			Model model		
			)
	{
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}

	/**
	 *  8. ON Click ''Excel Export''  HYPERLINK, URL : /excel  : GET , showExcel()
	 */

	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id", required = false) Integer id // optional
			) {

		ModelAndView m = new ModelAndView();
		// set the View , Model will show the View of the class we passed in it
		m.setView(new ShipmentTypeExcelView());

		if(id==null) // id == null Fetch All the DATA in Excel
		{
			List<ShipmentType> list = service.getAllShipmentTypes();
			// Adding the List<T> obj in MODEL with the Mapping key in EXCEL VIEW
			m.addObject("list", list);
		}
		else		// Fetch Only One Row in Excel
		{
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st)); // converting Object in List so that we can use that ExcelView logic for Both requirements
		}
		return m;
	}

	/**
	 * PDF EXPORT 
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id", required = false)Integer id
			)
	{
		ModelAndView m = new ModelAndView();
		// set the View, Model will show the View of the class we passed in it
		m.setView(new ShipmentTypePdfView());
		
		if(id==null) // id == null Fetch All the DATA in PDF
		{
			// Fetch All Data and SEND DATA to Pdf File (PdfView class)
			List<ShipmentType> list = service.getAllShipmentTypes();
			m.addObject("list", list); // the key "list" shud be matched in PdfView class
		}
		else	// Fetch Only One Row in PDF
		{
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st)); // converting Object in List so that we can use that PDFView logic for Both requirements
		}
		return m;
	}

	/**
	 *  Pie Chart and Bar chart
	 * 
	 */
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[ ]> list = service.getShipmentModeCount();
		String path = context.getRealPath("/");
		util.generatePieChart(path, list);
		util.generateBarChart(path, list);	
		return "ShipmentTypeCharts";
	}

}
