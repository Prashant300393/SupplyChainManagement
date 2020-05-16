package com.amdocs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.amdocs.model.Grn;
import com.amdocs.service.IGrnService;
import com.amdocs.service.IPurchaseOrderService;
import com.amdocs.util.CommonUtil;

@Controller
@RequestMapping("/grn")
public class GrnController {

	@Autowired
	private IGrnService service;

	@Autowired
	private IPurchaseOrderService poService;

	private void commonUi(Model model) {
		List<Object[ ]> poList = poService.getPurchaseIdAndCode();
		Map<Integer, String> poMap = CommonUtil.convert(poList);
		model.addAttribute("poMap", poMap);
	}

	@RequestMapping("/register")
	public String showGrnRegister(Model model) 
	{
		model.addAttribute("grn", new Grn());
		commonUi(model);
		return "GrnRegister";
	}

	@RequestMapping(value = "/save", method = POST)
	public String saveGrn(
			@ModelAttribute Grn grn,
			Model model
			) 
	{
		Integer id = service.saveGrn(grn);
		model.addAttribute("msg", "Grn created with "+id);
		poService.updatePoStatus(grn.getPo().getId(), "RECEIVED");
		model.addAttribute("grn", new Grn());
		commonUi(model);
		return "GrnRegister";
	}

	@RequestMapping(value = "/update",method = POST)
	public String updateGrn(
			@ModelAttribute Grn grn, 
			Model model) 
	{
		service.updateGrn(grn);
		model.addAttribute("message","Grn updated");
		List<Grn> list=service.getAllGrns();
		model.addAttribute("list",list);
		return "GrnData";
	}

	@RequestMapping("/delete")
	public String deleteGrn(
			@RequestParam Integer id,
			Model model)
	{
		service.deleteGrn(id);
		model.addAttribute("message","Grn deleted with Id:"+id);
		List<Grn> list=service.getAllGrns();
		model.addAttribute("list",list);
		return "GrnData";
	}

	@RequestMapping("/edit")
	public String editGrn(
			@RequestParam Integer id, 
			Model model) {
		Grn grn=service.getOneGrn(id);
		model.addAttribute("grn",grn);
		commonUi(model);
		return "GrnEdit";
	}

	@RequestMapping("/all")
	public String getAllGrns(Model map) {
		List<Grn> list=service.getAllGrns();
		map.addAttribute("list",list);
		return "GrnData";
	}

}
