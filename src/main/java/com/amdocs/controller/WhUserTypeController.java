package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.model.WhUserType;
import com.amdocs.service.IWhUserTypeService;
import com.amdocs.view.WhUserTypeExcelView;

import net.bytebuddy.description.field.FieldDescription.InGenericShape;

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
	public String showRegPage(Model model)
	{
		model.addAttribute("whUserType", new WhUserType());
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
		model.addAttribute("whUserType", new WhUserType());
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

		return "WhUserTypeData";
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
		return "WhUserTypeData";
	}
	
	/**
	 * 	On Click HYPERLINK "/edit?wid="  Read the key and Display the "WhUserTypeEdit.jsp"
	 *  URL : "/edit"	: GET , METHOD : showEditPage()
	 */
	@RequestMapping("/edit")	 // GET
	public String showEditPage(
			@RequestParam("wid") Integer id,
			Model model
			)
	{
		WhUserType wh = service.getOneWhUserType(id);
		model.addAttribute("whUserType", wh);
		return "WhUserTypeEdit";
	}
	
	/**
	 *  On Click "UPDATE" on "WhUserTypeEdit.jsp" Read the Form using @ModelAttribute
	 *  and Display the "WhUserTypeData.jsp" with the Success Message of update using MODEL
	 *  URL : "/update"	: POST , METHOD : updateWhUserType()
	 */
	
	@RequestMapping("/update")
	public String updateWhUserType(
			@ModelAttribute WhUserType whUserType,
			Model model
			)
	{
		service.updateWhUserType(whUserType);
		String msg = "WhUserType ' "+whUserType.getUserId()+" ' updated  ";
		// sending Success msg to UI
		model.addAttribute("msg", msg);
		// fetching Updated Data and Displaying on UI
		List<WhUserType> list = service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
		
	
	@RequestMapping("/view")
	public String viewOneWhUserType(
			@RequestParam("wid")Integer id,
			Model model
			)
	{
		WhUserType wh = service.getOneWhUserType(id);
		model.addAttribute("ob", wh);
		return "WhUserTypeView";
	}
	
	/**
	 *  EXCEL EXPORT  using MODELANDVIEW which is a 
	 *  HOLDER FOR for both MODEL(DATA) and VIEW(Page like pdf,excel)
	 *  
	 */
	
	@RequestMapping("/excel")
	public ModelAndView showExcel()
	{
		ModelAndView m = new ModelAndView();
		List<WhUserType> list = service.getAllWhUserTypes();
		m.addObject("list", list);
		m.setView(new WhUserTypeExcelView());
		return m;
	}
	
	
	
	
	

}
