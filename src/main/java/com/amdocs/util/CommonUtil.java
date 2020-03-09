package com.amdocs.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	/**
	 * Method to convert From List<Object[ ]> into Map, coz DATA comes in Object[ ] format
	 * Like ID(Integer) & CODE(String)
	 * 
	 *  So we have to convert in Map so that we can send the DATA to UI
	 */
	
	public static Map<Integer, String> convert(List<Object[ ]> list){
		
		Map<Integer, String> map = new HashMap<>();
		
		for (Object[ ] ob : list) {
			map.put(Integer.valueOf(ob[0].toString()), ob[1].toString());
		}
		return map;
	}
}
