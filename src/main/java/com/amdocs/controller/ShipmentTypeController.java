package com.amdocs.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.model.ShipmentType;
import com.amdocs.service.IShipmentTypeService;;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

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

	/**
	 * 1. Fetch the DATA from DATABASE and DISPLAY on UI in HTML TABLE FORMAT
	 * 	2. Showing DATA from CONTROLLER TO UI :: MODEL (interface, memory provided by CONTAINER)
	 * 
	 * 3. URL : "/all"  ,  TYPE : GET  , PAGE : "ShipmentTypeData.jsp"
	 */

	@RequestMapping("/all")	// GET
	public String getAllShipmentTypes(Model model)
	{
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/**
	 *   Deleting or editing one Row using URL Rewriting (Static path & Dynamic Path)
	 *   ===>REQUEST : delete?sid=10
	 *  
	 *   read the Key using @RequestParam and display on UI using  Model
	 *   URL : /delete , TYPE : GET , method = deleteShipment()
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
	 * Creating EDIT hyperlink in "ShipmentTypeData.jsp"
	 * URL : "/edit , GET	, Method : showEditPage()
	 * Read the ID using @RequestParam
	 * Return to "ShipmentTypeEdit" Page
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
	 *  On click UPDATE , Data Read using @ModelAttribute
	 *  URL : /update "POST"	, METHOD : updateShipmentType()
	 *  Return "ShipmentTypeData.jsp"	Success Msg
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
	 *  On click VIEW Hyperlink , One Row Data Displayed on "ShipmentTypeView.jsp"
	 *  URL : /view : GET , METHOD : showOneShipment()
	 *  Read key using @RequestParam and send Data using Model
	 */
	
	@RequestMapping("/view")	// GET
	public String showOneShipment( 
			@RequestParam("sid")Integer id,
			Model model		
			)
	{
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}





}
