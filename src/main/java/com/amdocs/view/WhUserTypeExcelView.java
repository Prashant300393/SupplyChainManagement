package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		//DOWNLOADING FILENAME
		response.setHeader("Content-Dispositon", "attachment;filename=whusers.xlsx");

		// 1. Create Sheet and Provide SheetName using WORKBOOK
		Sheet s = workbook.createSheet("WhUser Types");

		// 2. Construct Row-0 and Set the Column Name in Excel using SHEET
		Row row = s.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("FOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("ID TYPE");
		row.createCell(7).setCellValue("OTHER");
		row.createCell(8).setCellValue("ID NUMBER");

		List<WhUserType> list =(List<WhUserType>) model.get("list");
		int count = 1;
		for (WhUserType wh : list) {

			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(wh.getUserId());
			r.createCell(1).setCellValue(wh.getUserType());
			r.createCell(2).setCellValue(wh.getUserCode());
			r.createCell(3).setCellValue(wh.getUserFor());
			r.createCell(4).setCellValue(wh.getUserMail());
			r.createCell(5).setCellValue(wh.getUserContact());
			r.createCell(6).setCellValue(wh.getUserIdType());
			r.createCell(7).setCellValue(wh.getOther());
			r.createCell(8).setCellValue(wh.getIdNumber());

		}
	}
}
