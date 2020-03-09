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

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.amdocs.model.Part;
import com.amdocs.model.Uom;
import com.amdocs.service.IPartService;
import com.amdocs.service.IUomService;
import com.amdocs.view.PartExcelView;
import com.amdocs.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;

	@Autowired
	private IUomService uomService; // Link with UOM Module for Integeration

	/**
	 *  it will show the DropDown at UI( Register/Edit)
	 *  and its a Logic to get the All the UOM's, use this Logic wherever its Required
	 *  Like save/edit/update for this operations its required
	 */
	private void commonUi(Model model)
	{
		List<Uom> uomList = uomService.getAllUoms();
		model.addAttribute("uomList", uomList);
	}


	@RequestMapping("/register")
	public String showRegPage(Model model)
	{
		commonUi(model);
		model.addAttribute("part", new Part());
		return "PartRegister";
	}

	@RequestMapping(value = "/save", method = POST)
	public String savePart(
			@ModelAttribute Part part,
			Model model
			) 
	{
		Integer id = service.savePart(part);
		model.addAttribute("msg", id+"-saved");
		commonUi(model);
		model.addAttribute("part", new Part());
		return "PartRegister";
	}

	@RequestMapping("/all")
	public String showAllData(Model model)
	{
		List<Part> list = service.getAllParts();
		model.addAttribute("list", list);
		return "PartData";
	}

	@RequestMapping("/view")
	public String getOnePart(
			@RequestParam("id")Integer id,
			Model model
			)
	{
		Part p = service.getOnePart(id);
		model.addAttribute("ob", p);

		return "PartView";
	}

	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("id")Integer id,
			Model model
			)
	{
		service.deletePart(id);

		List<Part> list = service.getAllParts();
		model.addAttribute("list", list);

		model.addAttribute("msg", "Part"+id+" Deleted");
		return "PartData";
	}

	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam("id")Integer id,
			Model model
			)
	{
		commonUi(model);
		Part part = service.getOnePart(id);
		model.addAttribute("part",part);
		return "PartEdit";
	}

	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String updatePart(
			@ModelAttribute Part part,
			Model model
			) 
	{
		commonUi(model);
		service.updatePart(part);
		model.addAttribute("msg", part.getPartId()+" - Updated");
		model.addAttribute("part", new Part());

		return "PartData";
	}

	/**
	 *   Excel View
	 */

	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id", required = false)Integer id
			)
	{
		ModelAndView m = new ModelAndView();
		m.setView(new PartExcelView());

		// if id is null then ExcelView Logic will be for PartData.jsp Excel Download
		if(id==null) {
			List<Part> list = service.getAllParts();
			m.addObject("list", list);
		}
		else {	// This is for PartView ExcelDownload
 			Part p = service.getOnePart(id);
			m.addObject("list", Arrays.asList(p));
		}
		return m;
	}
	
	/**
	 *  	Part Pdf Export
	 */
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id", required = false)Integer id
			)
	{
		ModelAndView m= new ModelAndView();
		m.setView(new PartPdfView());
		
		if(id==null) { // It is for PartData pfd download when id==null it will download
			List<Part> list = service.getAllParts();
			m.addObject("list", list);
		}
		else {	// when id?={id}	it will download Pdf for specific data from PdfView.jsp
			Part p = service.getOnePart(id);
			m.addObject("list", Arrays.asList(p));
		}
		return m;
	}
	
	
	
	
	
	
	
	
	
	
}