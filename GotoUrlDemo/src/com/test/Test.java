package com.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

import com.gotourl.Util;

public class Test {

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void main(String[] args) throws JSONException {
//		String JsonContext = new Util().ReadFile("src/ReportList.json");
//		JSONTokener tokener = new JSONTokener(JsonContext);
//		JSONObject joResult = new JSONObject(tokener);
//
//		JSONArray jsonArray = joResult.getJSONArray("list");
//
//		int size = jsonArray.length();
//		System.out.println("Size: " + size);
//		for (int i = 0; i < size; i++) {
//			JSONObject jsonObject = jsonArray.getJSONObject(i);
//			System.out.println("[" + i + "]name=" + jsonObject.get("name"));
//			System.out.println("[" + i + "]path=" + jsonObject.get("path"));
//		}
		
		List<String> ss = new Test().parseStringListResult();
		print(System.getProperty("sun.arch.data.model"));
	}
	public static void print(Object obj){
		System.out.println(obj);
	}
	
	
	public List<String> parseStringListResult() {
		String JsonContext = new Util().ReadFile("src/test.json");
		List<String> ret = new ArrayList<String>();
		try {
			JSONTokener tokener = new JSONTokener(JsonContext);
			JSONObject joResult = new JSONObject(tokener);

			JSONArray words = joResult.getJSONArray("ws");
			for (int i = 0; i < words.length(); i++) {
				// 转写结果词，默认使用第一个结果
				JSONArray items = words.getJSONObject(i).getJSONArray("cw");
				JSONObject obj = items.getJSONObject(0);
				ret.add(obj.getString("w"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}