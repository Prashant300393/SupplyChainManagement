package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.OrderMethod;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// download File Name
		response.addHeader("Content-Disposition", "attachment;filename=ordermethods.pdf");
		
		// Create Element
		Paragraph p = new Paragraph("WELCOME TO ORDER METHODS", 
																	FontFactory.getFont(
																									FontFactory.HELVETICA_BOLD, 
																									24,
																									new Color(255, 80, 90)
																									));
		
		p.setIndentationLeft(80);
		p.setIndentationRight(30);
		// add the Element to Document
		document.add(p);
		document.add(Chunk.NEWLINE);
		
		// Read the Data from Model
		List<OrderMethod> list = (List<OrderMethod>)model.get("list");
		
		// Creating the Table with Num of Columns
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ACCEPT");
		t.addCell("NOTE");
	
		// Adding the Data in the Table
		for (OrderMethod om : list) {
			t.addCell(om.getOrderId().toString());
			t.addCell(om.getOrderMode());
			t.addCell(om.getOrderCode());
			t.addCell(om.getOrderType());
			t.addCell(om.getOrderAccept().toString());
			t.addCell(om.getOrderDesc());
		}
		
		// add the Table in Document
		document.add(t);
		document.add(Chunk.NEWLINE);
		
		document.add(new Paragraph(new Date().toString()));
			
	}
}

