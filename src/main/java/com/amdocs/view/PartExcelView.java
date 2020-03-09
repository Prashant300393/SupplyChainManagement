package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.Part;

public class PartExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		// download file name
		response.addHeader("Content-Disposition", "attachment;filename=part.xlsx");
		
		// create Sheet using workbook
		Sheet s = workbook.createSheet("Parts");
		
		// create Rows using sheet
		setHeader(s);
		
		// GET THE DATA FROM MODEL to set the VALUES IN CELL
		List<Part> list =  (List<Part>) model.get("list");
		
		//set the values in Rows using List Data
		setBody(s, list);
	}
	

	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("LEN");
		r.createCell(3).setCellValue("WID");
		r.createCell(4).setCellValue("HGHT");
		r.createCell(5).setCellValue("BASECOST");
		r.createCell(6).setCellValue("BASE CURRENCY");
		r.createCell(7).setCellValue("UOM");
		r.createCell(8).setCellValue("ORDER METHOD");
		r.createCell(9).setCellValue("NOTE");
	}

	private void setBody(Sheet s, List<Part> list) {
		int count = 1;

		for (Part part : list) {
			Row r = s.createRow(count++);
			
			r.createCell(0).setCellValue(part.getPartId().toString());
			r.createCell(1).setCellValue(part.getPartCode());
			r.createCell(2).setCellValue(part.getPartLen());
			r.createCell(3).setCellValue(part.getPartWid());
			r.createCell(4).setCellValue(part.getPartHgt());
			r.createCell(5).setCellValue(part.getBaseCost());
			r.createCell(6).setCellValue(part.getBaseCurrency());
			r.createCell(7).setCellValue(part.getUomOb().getUomModel());
			r.createCell(8).setCellValue(part.getOrderMethodOb().getOrderMode());
			r.createCell(9).setCellValue(part.getPdesc());
		}
	}

}
