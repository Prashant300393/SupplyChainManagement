package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.Uom;

public class UomExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		// FileName download
		response.setHeader("Content-Disposition", "attachment; filename=uoms.xlsx");
		// 1. create "Sheet" and Provide "SheetName" using WorkBook
		Sheet s = workbook.createSheet("Uom Data");
		// 2. Construct Row-0 and Set the Header or Column Name in Excel using Sheet
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(3).setCellValue("NOTE");

		// 3. Get the Data using "model.get("key")	which returns Object we have to DOWNCAST
		List<Uom> list = (List<Uom>) model.get("list");
		// 4. Contruct Row-1 onwards and Set the Data in it 
		int count = 1;
		for (Uom uom : list) {
			Row r1 = s.createRow(count++);
			r1.createCell(0).setCellValue(uom.getUomId());
			r1.createCell(1).setCellValue(uom.getUomType());
			r1.createCell(2).setCellValue(uom.getUomModel());
			r1.createCell(3).setCellValue(uom.getUomDesc());
		}
	}
}