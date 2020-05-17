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
import com.amdocs.model.GrnDtl;
import com.amdocs.model.PurchaseDtl;
import com.amdocs.model.PurchaseOrder;
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
		
		// this method has the logic to save GrnDtl in DB
		mapPoDtltoGrnDtlAndSave(grn);   // One PoDtl--------->>One GrnDtl
		
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


	//---------------------------Screen #2 Method---------------------------------------

	/**
	 * This method is used to get One PODTL and set to GRNDTL as it is for Screen #2
	 * But ToDo this..we have only GRN, by using GRN, we have to get PoId, then One PO, then PoDtl and set to GrnDtl
	 */
	public void mapPoDtltoGrnDtlAndSave(Grn grn) {
		// Get Po Id using Grn
		Integer poId = grn.getPo().getId();
		// Get One Po using PoId
		PurchaseOrder po = poService.getOnePurchaseOrder(poId);
		// Using PO get the PoDtl as List
		List<PurchaseDtl> poDtl = po.getChildDtl();

		// now Create GrnDtl and set the PoDtl to GrnDtl
		for(PurchaseDtl dtl : poDtl) {
			GrnDtl grnDtl = new GrnDtl();
			grnDtl.setPartCode(dtl.getPart().getPartCode());
			grnDtl.setBaseCost(dtl.getPart().getBaseCost());
			grnDtl.setQty(dtl.getQty());
			grnDtl.setPartStatus("NONE");

			// link with Grn(Screen #1)
			grnDtl.setGrn(grn);
			// finally save into DB
			service.saveGrnDtl(grnDtl);
		}// for

	}

	@RequestMapping("/viewGrnDtls")
	public String showGrnParts(
			@RequestParam("id") Integer id
			)	
	{
		
		return "GrnParts";
	}






}
