package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.model.Uom;
import com.amdocs.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	/**
	 * 1. This method is used to Display "UomRegister" Page
	 * 		URL : /register , Type : GET
	 *  	METHOD : showUomPage()
	 */

	@RequestMapping("/register")	// GET
	public String showUomPage()
	{
		return "UomRegister";
	}

	/**
	 * 2.	On Click "SUBMIT" : UomRegister Form
	 * 		Read the Data from UI to Controller : @ModelAttribute <clsName> <objName>
	 * 		Display the "SUCCESS" message using "Model" (interface) on SAME PAGE
	 * 
	 * 		URL : "/save" , TYPE : POST , METHOD : saveUom()
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUom(
			@ModelAttribute Uom uom,
			Model model
			)
	{
		Integer id = service.saveUom(uom);
		String msg = "UOM ' "+id+" ' Saved";
		model.addAttribute("msg", msg);
		return "UomRegister";
	}

	/**
	 * 3. Fetching Data from DataBase and Displaying on UI Page as HTML TABLE
	 * 
	 * 		URL : "/all"	, 	TYPE : GET , 	METHOD : getAllUoms() , PAGE : 	UomData.jsp
	 */
	
	@RequestMapping("/all")	// GET
	public String getAllUoms(Model model)
	{
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
	
	/**
	 * 4.  Deleting or Editing 1 Row using URL Rewriting (Static path & Dynamic Path)
	 *      ===>REQUEST : delete?uid=1
	 *  
	 *     Read the Key using @RequestParam & DISPLAY Remaining Data on Same UI using  Model
	 *     URL : /delete , TYPE : GET , method = deleteUom()
	 */
	@RequestMapping("/delete")		//GET
	public String deleteUom(
			@RequestParam("uid")Integer id,
			Model model
			)
	{
		service.deleteUom(id);
		String msg = "Uom ' "+id+" ' Deleted";
		model.addAttribute("msg", msg);
		//Fetching All new Data After Deletion
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
}
