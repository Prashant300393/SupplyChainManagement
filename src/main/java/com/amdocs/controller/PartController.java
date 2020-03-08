package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.amdocs.model.Part;
import com.amdocs.model.Uom;
import com.amdocs.service.IPartService;
import com.amdocs.service.IUomService;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;

	@Autowired
	private IUomService uomService; // Link with UOM Module for Integeration
	
	// it will show the DropDown at UI( Register/Edit)
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
	
}
