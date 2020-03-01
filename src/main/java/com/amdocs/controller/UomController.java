package com.amdocs.controller;

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

import com.amdocs.model.Uom;
import com.amdocs.service.IUomService;
import com.amdocs.util.UomUtil;
import com.amdocs.view.UomExcelView;
import com.amdocs.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@Autowired
	private UomUtil util;
	
	@Autowired
	private ServletContext context;
	
	/**
	 * 1. This method is used to Display "UomRegister" Page
	 * 		URL : /register , Type : GET
	 *  	METHOD : showUomPage()
	 */

	@RequestMapping("/register")	// GET
	public String showUomPage(Model model)
	{
		model.addAttribute("uom", new Uom());
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
		model.addAttribute("uom", new Uom());
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

	/**
	 * 	ON click HYPERLINK "EDIT" in UomData.jsp it will goto
	 * URL : "/edit?uid=_" : GET , METHOD : showEditPage()  PAGE : UomEdit.jsp
	 * 
	 * READ "uid" using @RequestParam and Display data using Model
	 */
	@RequestMapping("/edit")
	public String showEditUom(
			@RequestParam("uid")Integer uid,
			Model model		
			)
	{
		Uom uom = service.getOneUom(uid);
		model.addAttribute("uom", uom);
		return "UomEdit";
	}

	/**
	 * On Click "UPDATE"	 in "UomEdit.jsp"  
	 * URL : "/update" : POST , METHOD : updateUom() ,  PAGE: "UomData.jsp"
	 * using @ModelAttribute and Model
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(
			@ModelAttribute Uom uom,
			Model model
			)
	{
		service.updateUom(uom);
		String msg = "Uom '"+uom.getUomId()+"' Updated  ";
		model.addAttribute("msg", msg);
		//fetching new Data
		List<Uom> list = service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
		//		return "redirect:all";
	}
	/**
	 * On Click "VIEW" HYPERLINK get Data based on PK and
	 * send to UI PAGE "UomView.jsp"  HTML TABLE FORMAT
	 * using MODEL , URL : "/view"	: GET 
	 */

	@RequestMapping("/view")
	public String viewOneUom(
			@RequestParam("uid")Integer id,
			Model model	)
	{
		Uom uom = service.getOneUom(id);
		model.addAttribute("uom", uom);
		return "UomView";
	}
	/**
	 * EXCEL EXPORT
	 */

	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id", required = false)Integer id // optional
			)
	{
		ModelAndView m = new ModelAndView();
		// Setting the EXCEL VIEW OBJECT
		m.setView(new UomExcelView());

		if(id==null)	// id is null then Add all the Data 
		{				
			List<Uom> list = service.getAllUoms();
			// Adding the List<T> obj in MODEL with the Mapping key in EXCEL VIEW
			m.addObject("list", list);
		}
		else  // id is not null then Add only One Row Data
		{
			Uom uom = service.getOneUom(id);
			m.addObject("list", Arrays.asList(uom));	// converting Object in List so that we can use that ExcelView logic for Both requirements
		}
		return m;
	}
	
	/**
	 *   PDF EXPORT
	 */

	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id", required = false)Integer id
			)
	{
		ModelAndView m = new ModelAndView();
		m.setView(new UomPdfView());

		if(id==null) // id is null then Add all the Data 
		{
			List<Uom> list = service.getAllUoms();
			m.addObject("list", list);
		}
		else // id is not null then Add only One Row Data
		{
			Uom uom = service.getOneUom(id);
			m.addObject("list", Arrays.asList(uom)); // converting Object in List so that we can use that PDFView logic for Both requirements
		}
		return m;
	}
	
	/**
	 *  Pie chart & Bar chart
	 */
	@RequestMapping("/charts")
	public String showChart() {
		
		List<Object[ ]> list = service.getUomTypeCount();
		String path = context.getRealPath("/");
		util.generatePieChart(path, list);
		util.generateBarChart(path, list);
		return "UomCharts";
	}
	
}
