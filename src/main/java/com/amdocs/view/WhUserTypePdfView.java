package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.WhUserType;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// download File Name
		response.addHeader("Content-Disposition", "attachment;filename=whusertypes.pdf");
		
		// Create Element
		Paragraph p = new Paragraph("WELCOME TO Wh User Types", 
																	FontFactory.getFont(
																									FontFactory.HELVETICA_BOLD, 
																									24,
																									new Color(0, 255, 0)
																									));
		
		p.setIndentationLeft(80);
		p.setIndentationRight(30);
		// add the Element to Document
		document.add(p);
		document.add(Chunk.NEWLINE);
		
		// Read the Data from Model
		List<WhUserType> list = (List<WhUserType>)model.get("list");
		
		// Creating the Table with Num of Columns
		PdfPTable t = new PdfPTable(9);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("FOR");
		t.addCell("MAIL");
		t.addCell("CONTACT");
		t.addCell("ID TYPE");
		t.addCell("OTHER");
		t.addCell("ID NUMBER");
	
		// Adding the Data in the Table
		for (WhUserType wh : list) {
			t.addCell(wh.getUserId().toString());
			t.addCell(wh.getUserType());
			t.addCell(wh.getUserCode());
			t.addCell(wh.getUserFor());
			t.addCell(wh.getUserMail());
			t.addCell(wh.getUserContact());
			t.addCell(wh.getUserIdType());
			t.addCell(wh.getOther());
			t.addCell(wh.getIdNumber());
		}
		
		// add the Table in Document
		document.add(t);
		document.add(Chunk.NEWLINE);
		
		document.add(new Paragraph(new Date().toString()));
			
	}
}
