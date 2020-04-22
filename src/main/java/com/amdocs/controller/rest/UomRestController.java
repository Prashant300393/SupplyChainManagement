package com.amdocs.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.amdocs.model.Uom;
import com.amdocs.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;

	@GetMapping("/all")
	public ResponseEntity<?> fetchAllUoms(){

		ResponseEntity<?> resp = null;

		try {

			List<Uom> uom = service.getAllUoms();
			
			if(uom!=null && !uom.isEmpty()) { // If List is not Empty and Not Null
				resp = new ResponseEntity<List<Uom>>(uom, HttpStatus.OK);
			}
			else {
			 // resp = new ResponseEntity<String>("No Uoms Found ", HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
		} 
		catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Fetch Records"	, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	@GetMapping("/one")
	public ResponseEntity<?> getOneUom(
			@RequestParam ("id")Integer id
			)
	{
		ResponseEntity<?> resp = null;

		try {
			
			Uom uom = service.getOneUom(id);
			if(uom!=null) {	// if exist
				resp = new ResponseEntity<Uom>(uom, HttpStatus.OK);
			}
			else {	// Id not Exist
				resp = new ResponseEntity<String>(" ' "+uom.getUomId()+" ' Not Exist", HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Found Uom ", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}


	@DeleteMapping("/remove")
	public ResponseEntity<String> removeUom(
			@RequestParam ("id")Integer id
			)
	{
		ResponseEntity<String> resp = null;
		try {
		
			service.deleteUom(id);
			resp = new ResponseEntity<String>("Uom '"+id+"' Deleted", HttpStatus.OK);
	
		}
		catch (Exception e) {
			resp = new ResponseEntity<String>(" Id-'"+id+"' Not Exist", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveUom(
			@RequestBody Uom uom
			)
	{
		ResponseEntity<String> resp = null;
		try {
			
			Integer id = service.saveUom(uom);
			resp = new ResponseEntity<String>(" Uom ' "+id+" ' Saved ", HttpStatus.CREATED); // 201(Status Code)	
			
		} catch (Exception e) {
			resp = new ResponseEntity<String>(" Unable to Save ", HttpStatus.INTERNAL_SERVER_ERROR);	
			e.printStackTrace();
		}
		return resp;
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateUom(
			@RequestBody Uom uom
			)
	{
		ResponseEntity<String> resp = null;
		try {
			
			service.updateUom(uom);																											// 205
			resp = new ResponseEntity<String>(" Uom ' "+uom.getUomId()+" ' Updated  ", HttpStatus.RESET_CONTENT);
			
		} catch (Exception e) {
			resp = new ResponseEntity<String>(" Unable to Update,' "+uom.getUomId()+" ' Not Exist", HttpStatus.RESET_CONTENT);
			e.printStackTrace();
		}
		return resp;
	}
	
}// class
