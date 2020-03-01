package com.amdocs.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {

	public void generatePieChart(String path, List<Object[ ]> data) {

		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] arr : data) {
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}

		JFreeChart chart = ChartFactory.createPieChart3D("Uom Types", dataset, true, true, false);

		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/uomA.png"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	BAR CHART
	 */
	public void generateBarChart(String path, List<Object[ ]> data) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] arr : data) {
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(), "");
		}

		JFreeChart chart = ChartFactory.createBarChart("Uom Types", "Types", "COUNT", dataset);

		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/uomB.png"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
