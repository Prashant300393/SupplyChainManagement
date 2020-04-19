package com.amdocs.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amdocs.model.WhUserType;
import com.amdocs.service.IWhUserTypeService;

@Component
public class WhUserTypeValidator implements Validator{

	@Autowired
	private IWhUserTypeService service;
	
	/**
	 *  This method means it will support only WhUserType class validation
	 */
	@Override
	public boolean supports(Class<?> cls) {
		return WhUserType.class.equals(cls);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		// target we need to downcast 
		WhUserType user = (WhUserType)target;
		
		// Logic to validate [ call service method to Validate isUserCodeExist() or not?
		
		if(service.isUserCodeExist(user.getUserCode())) {	
			// if Exist then add ERROR MSG
			errors.rejectValue("userCode", null, "\""+user.getUserCode()+"\" "+" already Exist..!");
		}
		
		if(service.isUserMailExist(user.getUserMail())) {
			// if Exist then add ERROR MSG
			errors.rejectValue("userMail", null, "\""+user.getUserMail()+"\" " +" already Exist..!");
		}
		
		if(service.isUserContactExist(user.getUserContact())) {
			// if Exist then add ERROR MSG
			errors.rejectValue("userContact", null, "\""+user.getUserContact()+"\" "+" already Exist..!");
		}
	}
	
}
