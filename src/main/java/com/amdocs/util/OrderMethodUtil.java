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
public class OrderMethodUtil {

	public void generatePieChar(String path, List<Object[ ]> data)
	{
		// 1. List Data convert to Dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[ ] arr : data) {
			// { key-index-0 (MODES) , value-index-1 (count) }
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}
		// 2. Create PieChart using CharFactory(AC) : JFreeChart
		JFreeChart chart = ChartFactory.createPieChart("Order Modes", dataset, true, true, false);
		// 3. Save Chart as Image using ChartUtils(AC)
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/orderA.png"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  BAR CHART
	 */
	public void generateBarChart(String path, List<Object[ ]> data) {
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] arr : data) {
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(), "");
		}
		JFreeChart chart = ChartFactory.createBarChart("Order Modes", "MODES", "COUNT", dataset);
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/orderB.png"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}//class
