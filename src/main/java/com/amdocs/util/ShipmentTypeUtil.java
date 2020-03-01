package com.amdocs.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {

	public void generatePieChart(String path, List<Object[ ]> data)
	{
		// 1. List DATA Convert to Dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[ ] arr : data) {
			// key-shipMode   , value - count index
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}
		// 2. create JFreeChart using ChartFactory takes (title, dataset, legend, tooltips, urls)
		JFreeChart chart = ChartFactory.createPieChart3D("Shipment Modes", dataset, true, true, false);
		// 3. save as Image using ChartUtils
		try {														// ( file, char, widht , height)
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipmentA.jpg"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  BAR CHART
	 */
	public void generateBarChart(String path , List<Object[ ]> data) {
		
		// 1. List Data convert to DataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// value = index-1 (y-axis)    ,  key = index-0 (x-axis) , ("")
		for (Object[ ] arr : data) {
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(), "");
		}
		// 2. Create JFreeChart using ChartFactory takes (title, xAxisLabel , yAxisLabel, dataset) 		
		JFreeChart chart = ChartFactory.createBarChart("Shipment Modes", "MODES", "COUNT", dataset);
		// Save as Image using ChartUtils
		try {															// ( file, char, widht , height)
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/shipmentB.png"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}//class
