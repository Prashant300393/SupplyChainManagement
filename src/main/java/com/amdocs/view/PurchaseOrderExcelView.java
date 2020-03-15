package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.PurchaseOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		// 1. download file name
		response.addHeader("Content-Disposition", "attachment;filename=purchase_orders.xlsx");
		
		// 2. create Sheet & Provide SheetName using workbook 
		Sheet s = workbook.createSheet("purchase_orders");
		
		// 3. set the Column and at Row 0(zero) using Sheet
		setHeader(s);
		
		// 4. get the Data as List from Controller
		List<PurchaseOrder> list = (List<PurchaseOrder>) model.get("list");
		
		// 5. Provide data to cell using List Data
		setBody(s, list);	

	} // method
	
	// Setting Body i.e. Data inside the Excel	
	private void setBody(Sheet s, List<PurchaseOrder> list) {
		int count=1;
		for(PurchaseOrder po : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(po.getId());
			r.createCell(1).setCellValue(po.getPoOrderCode());
			r.createCell(2).setCellValue(po.getShipOb().getShipCode());
			r.createCell(3).setCellValue(po.getWhVendor().getUserCode());
			r.createCell(4).setCellValue(po.getPoRefNum());
			r.createCell(5).setCellValue(po.getPoQltyCheck());
			r.createCell(6).setCellValue(po.getPoStatus());
			r.createCell(7).setCellValue(po.getPoDesc());
		}//for

	}
	// Setting Header i.e. Column Names in Excel
	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("SHIPMENT CODE");
		r.createCell(3).setCellValue("VENDOR CODE");
		r.createCell(4).setCellValue("REF. NO");
		r.createCell(5).setCellValue("QUALITY CHECK");
		r.createCell(6).setCellValue("STATUS");
		r.createCell(7).setCellValue("NOTE");
	}

}//class
