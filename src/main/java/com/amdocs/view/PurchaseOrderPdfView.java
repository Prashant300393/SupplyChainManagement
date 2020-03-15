package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.PurchaseOrder;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchaseOrderPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
	
		// 1. download file name
		response.addHeader("Content-Disposition", "attachment;filename=purchase_orders.pdf");
		
		// create element
		Paragraph p = new Paragraph("WELCOME TO PURCHASE ORDERS"
														,FontFactory.getFont(FontFactory.HELVETICA, 12, new  Color(0, 0, 255))
														);
		
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		document.add(Chunk.NEWLINE);
		
		// read data from model
		List<PurchaseOrder> list = (List<PurchaseOrder>) model.get("list");
		
		// create Tabel inside Document
		PdfPTable t = new PdfPTable(8);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("SHIPMENT CODE");
		t.addCell("VENDOR CODE");
		t.addCell("REF.NO");
		t.addCell("QLTY CHECK");
		t.addCell("STATUS");
		t.addCell("NOTE");
	
		// Adding Data to Table
		for(PurchaseOrder po : list) {
			t.addCell(po.getId().toString());
			t.addCell(po.getPoOrderCode());
			t.addCell(po.getShipOb().getShipCode());
			t.addCell(po.getWhVendor().getUserCode());
			t.addCell(po.getPoRefNum());
			t.addCell(po.getPoQltyCheck());
			t.addCell(po.getPoStatus());
			t.addCell(po.getPoDesc());
		}
	
		t.setWidthPercentage(95f);
		document.add(t);
		document.add(Chunk.NEWLINE);
		document.add(new Chunk(new Date().toString()));
		
	}
}
