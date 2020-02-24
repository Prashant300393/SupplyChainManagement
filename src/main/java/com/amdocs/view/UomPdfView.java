package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.Uom;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
		// download file name
		response.addHeader("Content-Disposition", "attachment;filename=uoms.pdf");

		// Create Element
		Paragraph p = new Paragraph("WELCOME TO UOM ", FontFactory.getFont( 
																								FontFactory.TIMES_BOLD, 
																								24, 
																								new Color(255, 0, 0)));

		p.setIndentationLeft(80);
		p.setIndentationRight(50);
		// add element to Document
		document.add(p);
		document.add(Chunk.NEWLINE);

		// read Data from Model
		List<Uom> list = (List<Uom>)model.get("list");

		// Creating Table with Num of Columns
		PdfPTable t = new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("NOTE");

		// Adding the Data in Table
		for (Uom uom : list) {
			t.addCell(uom.getUomId().toString());
			t.addCell(uom.getUomType());
			t.addCell(uom.getUomModel());
			t.addCell(uom.getUomDesc());
		}
		
		// Add Table to Document
		document.add(t);
		document.add(Chunk.NEWLINE);
		
		document.add(new Paragraph(new Date().toString()));
	}
}

