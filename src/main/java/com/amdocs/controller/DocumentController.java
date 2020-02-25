package com.amdocs.controller;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showUploadPage()
	{
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
			Integer id = service.saveDocument(doc);
			String msg = fileId+" is Uploaded";
			model.addAttribute("msg", msg);
		}
		return "Documents";
	}


}
