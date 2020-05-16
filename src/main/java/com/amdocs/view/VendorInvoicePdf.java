package com.amdocs.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amdocs.model.PurchaseDtl;
import com.amdocs.model.PurchaseOrder;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorInvoicePdf  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest req, HttpServletResponse resp) throws Exception 
	{
		// download file name 
		resp.addHeader("Content-Disposition", "attachment;filename=VendorInvoice.pdf");
		
		// Create Element
		Paragraph p = new Paragraph("WELCOME TO VENDOR INVOICE PDF", 
															FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, 
																							 new Color(0, 0, 255)));
		
		p.setIndentationLeft(50);
		p.setIndentationRight(50);
		document.add(p);
		document.add(Chunk.NEWLINE);
		
		// read Purchase Order from Controller
		PurchaseOrder po = (PurchaseOrder)model.get("po");
		
		// get the Child(PurchaseDtl parts) from the PO
		List<PurchaseDtl> parts = po.getChildDtl();
		
		double finalCost=0;
		for(PurchaseDtl dtl : parts) {
			finalCost+=dtl.getPart().getBaseCost()*dtl.getQty();
		}

		PdfPTable tableHeader = new PdfPTable(4);
		tableHeader.addCell("VENDOR CODE"); tableHeader.addCell(po.getWhVendor().getUserCode());
		tableHeader.addCell("ORDER CODE"); tableHeader.addCell(po.getPoOrderCode());
		tableHeader.addCell("FINAL COST"); tableHeader.addCell(Double.toString(finalCost));
		tableHeader.addCell("SHIPMENT CODE"); tableHeader.addCell(po.getShipOb().getShipCode());
		
		document.add(tableHeader);
		document.add(Chunk.NEWLINE);
		
		// Creating the Table with Number of Columns
		PdfPTable table = new PdfPTable(4);
		table.addCell("Part Code");
		table.addCell("Base Cost");
		table.addCell("Quantity");
		table.addCell("Total Cost");
		
		// Add Data To Table
		for(PurchaseDtl dtl : parts) {
			
			table.addCell(dtl.getPart().getPartCode());
			table.addCell(dtl.getPart().getBaseCost().toString());
			table.addCell(dtl.getQty().toString());
			table.addCell( Double.toString(dtl.getPart().getBaseCost()*dtl.getQty()));
		}
		
		document.add(new Paragraph("Part Details"));
		document.add(table);
		document.add(Chunk.NEWLINE);
		document.add(new Paragraph(new Date().toString()));		
		
	}
	
	
}
