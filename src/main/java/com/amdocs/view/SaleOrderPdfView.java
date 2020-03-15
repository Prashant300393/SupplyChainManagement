package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.SaleOrder;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class SaleOrderPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
		response.addHeader("Content-Disposition", "attachment;filename=sale_orders.pdf");
		
		Paragraph p = new Paragraph("WELCOME TO SALE ORDERS",
														FontFactory.getFont(FontFactory.HELVETICA, 12, new Color(0, 0, 255))
														 );
		
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		document.add(Chunk.NEWLINE);
		
		// get the Data from Model
		List<SaleOrder> list = (List<SaleOrder>) model.get("list");
		
		PdfPTable t = new PdfPTable(9);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("SHIPMENT CODE");
		t.addCell("CUST CODE");
		t.addCell("REF.NO");
		t.addCell("SOURCE MODE");
		t.addCell("SOURCE CODE");
		t.addCell("STATUS");
		t.addCell("NOTE");

		// Adding Data to Table
		for(SaleOrder so : list) {
			t.addCell(so.getSaleId().toString());
			t.addCell(so.getSaleCode());
			t.addCell(so.getShipOb().getShipCode());
			t.addCell(so.getWhCust().getUserCode());
			t.addCell(so.getSaleRefNo());
			t.addCell(so.getStockMode());
			t.addCell(so.getStockSource());
			t.addCell(so.getStatus());
			t.addCell(so.getSaleDesc());
		}
	
		t.setWidthPercentage(95f);
		document.add(t);
		document.add(Chunk.NEWLINE);
		document.add(new Chunk(new Date().toString()));
	
	}
}
