package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.model.WhUserType;
import com.amdocs.service.IWhUserTypeService;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	/**
	 * 1.  This method used to Display "WhUserRegister.jsp" 
	 *      URL : /register , Type = GET , METHOD : showRegPage()
	 */

	@RequestMapping("/register") // GET
	public String showRegPage()
	{
		return "WhUserTypeRegister";
	}

	/**
	 * 2.	On Click "SUBMIT" : WhUserRegister Form
	 * 		Read the Data from UI to Controller : @ModelAttribute <clsName> <objName>
	 * 		Display the "SUCCESS" message using "Model" (interface) on SAME PAGE
	 * 
	 * 		URL : "/save" , TYPE : POST , METHOD : saveWhUser()
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWhUser(
			@ModelAttribute WhUserType whUserType,
			Model model
			)
	{
		Integer id = service.saveWhUserType(whUserType);
		String msg = "WhUserType ' "+id+" ' Saved...!!!!! ";
		//		String msg1 = "WhuserType"+id+"Saved";
		model.addAttribute("msg", msg);		
		return "WhUserTypeRegister";
	}

	/**
	 * 3. URL : "/all"  ,  TYPE : GET  , PAGE : "WhUserData.jsp" . METHOD : getAllWhUser()
	 */

	@RequestMapping("/all") 	// GET
	public String getAllWhUsers(Model model) 
	{
		List<WhUserType> list = service.getAllWhUserTypes();
		model.addAttribute("list", list);

		return "WhUserData";
	}

	/**
	 * 4.  Deleting or Editing 1 Row using URL Rewriting (Static path & Dynamic Path)
	 *      ===>REQUEST : delete?wid=10
	 *  
	 *     Read the Key using @RequestParam & DISPLAY Remaining Data on Same UI using  Model
	 *     URL : /delete , TYPE : GET , method = deleteWhUser()
	 */

	@RequestMapping("/delete")	// GET
	public String deleteWhUser(
			@RequestParam("wid")Integer id,
			Model model
			)
	{
		service.deleteWhUserType(id);
		String msg = "WhUser ' "+id+" ' Deleted  ";
		model.addAttribute("msg", msg);
		List<WhUserType> list = service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserData";
	}

}
