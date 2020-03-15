package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.SaleOrder;

public class SaleOrderExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		response.addHeader("Content-Dispositon", "attachment;filename=sale_orders.xlsx");
		
		Sheet s = workbook.createSheet("SALE_ORDER");
		
		setHeader(s);
		
		List<SaleOrder> list = (List<SaleOrder>)model.get("list");
		
		setBody(s,list);
	}

	private void setBody(Sheet s, List<SaleOrder> list) {
		int count = 1;
		for(SaleOrder so : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(so.getSaleId());
			r.createCell(1).setCellValue(so.getSaleCode());
			r.createCell(2).setCellValue(so.getShipOb().getShipCode());
			r.createCell(3).setCellValue(so.getWhCust().getUserCode());
			r.createCell(4).setCellValue(so.getSaleRefNo());
			r.createCell(5).setCellValue(so.getStockMode());
			r.createCell(6).setCellValue(so.getStockSource());
			r.createCell(7).setCellValue(so.getStatus());
			r.createCell(8).setCellValue(so.getSaleDesc());
	
		}
	}

	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("SHIPMENT CODE");
		r.createCell(3).setCellValue("CUST CODE");
		r.createCell(4).setCellValue("REF.NO");
		r.createCell(5).setCellValue("STOCK MODE");
		r.createCell(6).setCellValue("STOCK SOURCE");
		r.createCell(7).setCellValue("STATUS");
		r.createCell(8).setCellValue("NOTE");
	}
}

