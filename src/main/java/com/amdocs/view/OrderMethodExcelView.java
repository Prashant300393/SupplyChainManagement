package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		// Downloading fileName
		response.setHeader("Content-Disposition", "attachment; filename=ordermethods.xlsx");

		// 1. Create Sheet and Provide Sheet Name using WorkBook
		Sheet s = workbook.createSheet("Order Methods");

		// 2. Construct ROW-0 using Sheet and create Cell using Row and Set the Column Name in EXCEL
		Row row = s.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("ACCEPT");
		row.createCell(5).setCellValue("NOTE");

		// 3. GET the DATA using MODEL which HOLDS the DATA 
		List<OrderMethod>list = (List<OrderMethod>) model.get("list");
		int count = 1;
		for (OrderMethod om : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(om.getOrderId());
			r.createCell(1).setCellValue(om.getOrderMode());
			r.createCell(2).setCellValue(om.getOrderCode());
			r.createCell(3).setCellValue(om.getOrderType());
			r.createCell(4).setCellValue(om.getOrderAccept().toString());
			r.createCell(5).setCellValue(om.getOrderDesc());
		}
	}
}
