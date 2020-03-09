package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.Part;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class PartPdfView extends AbstractPdfView{


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
		response.addHeader("Content-Disposition", "attachment;filename=parts.pdf");

		// Create Element
		Paragraph p = new Paragraph("WELCOME TO PARTS", 
				FontFactory.getFont(FontFactory.HELVETICA, 24, new Color(0, 0, 255)));

		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		document.add(Chunk.NEWLINE);

		// read Data from model
		List<Part> list = (List<Part>) model.get("list");


		// creating Table with no of Columns
		//specify column widths
		float[ ] columnWidths = {1f, 2f, 1.5f,1.5f, 2f, 3.5f, 6f, 2f, 3f};
		//create PDF table with the given widths
		PdfPTable table = new PdfPTable(columnWidths);
		// set table width a percentage of the page width
		table.setWidthPercentage(90f);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
		
		   //insert column headings
		   insertCell(table, "ID", Element.ALIGN_CENTER, 1, font);
		   insertCell(table, "CODE", Element.ALIGN_CENTER, 1, font);
		   insertCell(table, "LEN", Element.ALIGN_LEFT, 1, font);
		   insertCell(table, "WID", Element.ALIGN_LEFT, 1, font);
		   insertCell(table, "HGHT", Element.ALIGN_LEFT, 1, font);
		   insertCell(table, "BASE COST", Element.ALIGN_LEFT, 1, font);
		   insertCell(table, "BASE CURRENCY", Element.ALIGN_LEFT, 1, font);
		   insertCell(table, "UOM", Element.ALIGN_CENTER, 1, font);
		   insertCell(table, "NOTE", Element.ALIGN_CENTER, 1, font);
		   table.setHeaderRows(1);
		
		   
		   
		//		t.addCell("ID");
		//		t.addCell("CODE");
		//		t.addCell("LEN");
		//		t.addCell("WID");
		//		t.addCell("HGHT");
		//		t.addCell("BASECOST");
		//		t.addCell("BASE CURRENCY");
		//		t.addCell("UOM");
		//		t.addCell("NOTE");



		// Adding Data to Table
		for (Part part : list) {
			
			   insertCell(table, part.getPartId().toString(), Element.ALIGN_CENTER, 1, font);
			   insertCell(table, part.getPartCode(), Element.ALIGN_CENTER, 1, font);
			   insertCell(table, part.getPartLen().toString(), Element.ALIGN_LEFT, 1, font);
			   insertCell(table, part.getPartWid().toString(), Element.ALIGN_LEFT, 1, font);
			   insertCell(table, part.getPartHgt().toString(), Element.ALIGN_LEFT, 1, font);
			   insertCell(table, part.getBaseCost().toString(), Element.ALIGN_LEFT, 1, font);
			   insertCell(table, part.getBaseCurrency(), Element.ALIGN_LEFT, 1, font);
			   insertCell(table, part.getUomOb().getUomModel(), Element.ALIGN_CENTER, 1, font);
			   insertCell(table, part.getPdesc(), Element.ALIGN_CENTER, 1, font);
	
//			t.addCell(part.getPartId().toString());
//			t.addCell(part.getPartCode());
//			t.addCell(part.getPartLen().toString()	);
//			t.addCell(part.getPartWid().toString());
//			t.addCell(part.getPartHgt().toString());
//			t.addCell(part.getBaseCost().toString());
//			t.addCell(part.getBaseCurrency());
//			t.addCell(part.getUomOb().getUomModel());
//			t.addCell(part.getPdesc());
		}
		table.setWidthPercentage(90f);
		document.add(table);
		document.add(Chunk.NEWLINE);
		document.add(new Chunk(new Date().toString()));
	}


	private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){

		//create a new cell with the specified Text and Font
		PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		//set the cell alignment
		cell.setHorizontalAlignment(align);
		//set the cell column span in case you want to merge two or more cells
		cell.setColspan(colspan);
		//in case there is no text and you wan to create an empty row
		if(text.trim().equalsIgnoreCase("")){
			cell.setMinimumHeight(10f);
		}
		//add the call to the table
		table.addCell(cell);

	}


}
