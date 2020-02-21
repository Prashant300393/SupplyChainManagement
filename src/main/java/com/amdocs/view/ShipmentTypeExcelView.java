package com.amdocs.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.amdocs.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model,
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{

		//	Download Filename  
		response.setHeader("Content-Disposition", "attachment; filename=shipments.xlsx");

		//1. Create Sheet and Provide Name using 'WorkBook'
		Sheet s = workbook.createSheet("Shipment Types");
	
		// 2. Construct Row Using Sheet
		setHeader(s);

		// 3. Get the Data from MODEL mapped with Key and Set Data in Cells
		List<ShipmentType>list = (List<ShipmentType>) model.get("list");
		setBody(s, list);
	}

	private void setHeader(Sheet s) {

		Row row = s.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLED");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("NOTE");
	}


	private void setBody(Sheet s, List<ShipmentType> list) {

		int count = 1;
		// Traversing List for Num of Objects Present in the List and Setting into the Cell
		for (ShipmentType st : list) {
			Row row = s.createRow(count++);
			row.createCell(0).setCellValue(st.getShipId());
			row.createCell(1).setCellValue(st.getShipMode());
			row.createCell(2).setCellValue(st.getShipCode());
			row.createCell(3).setCellValue(st.getEnbShip());
			row.createCell(4).setCellValue(st.getShipGrade());
			row.createCell(5).setCellValue(st.getShipDesc());
		}
	}
}