package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.ShipmentType;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView  extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
		// download fileName 
		response.addHeader("Content-Disposition", "attachment;filename=shipment.pdf");
		
		// Create Element
		Paragraph p = new Paragraph("WELCOME TO SHIPMENT TYPE", 
															FontFactory.getFont(
															FontFactory.HELVETICA,
															 24, 
															 new Color(0, 0, 255)));
		p.setIndentationLeft(50);
		p.setIndentationRight(50);
		document.add(p);
		document.add(Chunk.NEWLINE);

		// read Data From Model
		List<ShipmentType>list = (List<ShipmentType>) model.get("list"); // key shud be matched with ModelAndView in Controller
		
		// Creating the Table with Number of Columns
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLE");
		t.addCell("GRADE");
		t.addCell("NOTE");

		// Add DATA to Table
		for (ShipmentType st : list) {
			t.addCell(st.getShipId().toString());
			t.addCell(st.getShipMode());
			t.addCell(st.getShipCode());
			t.addCell(st.getEnbShip());
			t.addCell(st.getShipGrade());
			t.addCell(st.getShipDesc());
		}
		// adding Table to Document
		document.add(t);
		document.add(Chunk.NEWLINE);
		
		// add DATE and TIME 
		document.add(new Chunk(new Date().toString()));
	}
}
