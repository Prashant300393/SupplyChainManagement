package com.amdocs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.amdocs.model.Document;
import com.amdocs.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;

	// 1. Show Document Upload Page
	@RequestMapping("/show")
	public String showUploadPage(Model model)
	{
		List<Object[ ]> list = service.getFileIdAndNames();
		model.addAttribute("list", list);

		return "Documents";
	}

	// 2. Upload Data and Save into DB
	@RequestMapping("/upload")
	public String doUpload(
			@RequestParam Integer fileId,  	// reading the inputs from UI
			@RequestParam CommonsMultipartFile fileOb,  // fileOb Contains OrginalFilename + fileData(in bytes)
			Model model
			)
	{
		if(fileOb!=null)
		{
			Document doc = new Document();
			doc.setFileId(fileId);
			doc.setFileName(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			// saving the File in DB
			service.saveDocument(doc);
		}
		return "redirect:show";
	}

	/**
	 *  For FILE DOWNLOAD we have to read the Requested ID from the HYPERLINK using @RequestParam 
	 * we need to call service.getOneDocument(.class, ID) which returns DOC OBJ contains 3 THINGS
	 * 
	 * FILE ID , FILE NAME , FILE DATA 
	 * 1. We have to set the FILENAME to HTTP Response Head Section
	 * 2. We have to COPY the FILE DATA as INPUTSTREAM AND set to OUTPUTSTREAM 
	 * 			
	 * 		Using FileCopyUtils Abstract Class provides "copy(in, out)" static method 									
	 */
	
	@RequestMapping("/download")
	public String doDownload(
			@RequestParam Integer id,
			HttpServletResponse resp
			)
	{
		Document doc = service.getOneDocument(id);
		// setting the FILENAME in RESPONSE HEADER 
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		try {
			// Copying the FileData to Response OutputStream
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Documents";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
