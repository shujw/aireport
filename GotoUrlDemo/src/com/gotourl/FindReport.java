package com.gotourl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.test.Test;

public class FindReport {

	public Map<String, String> findReport(List<String> strCmd) {
		Map<String, String> resultMap = new HashMap<String, String>();
		String reportPath = "";

		Map<String, String> reportList = getReportList();

		// TODO
		Test test = new Test();
		List<String> testCmd = strCmd;
		// List<String> testCmd = test.parseStringListResult();

		for (Entry<String, String> entry : reportList.entrySet()) {
			System.out.println("reportList ##### " + entry.getKey());
			boolean isExist = false;
			for (String cmd : testCmd) {
				System.out.println("cmd ##### " + cmd);
				if (entry.getKey().contains(cmd)) {
					isExist = true;
					break;
				}
			}

			if (isExist) {
				resultMap.put(entry.getKey(), entry.getValue());
			}
		}

		return resultMap;
	}

	public Map<String, String> getReportList() {
		Map<String, String> resultMap = new HashMap<String, String>();
		String JsonContext = new Util().ReadFile("src/ReportList.json");
		JSONTokener tokener = new JSONTokener(JsonContext);
		JSONObject joResult = null;
		JSONArray jsonArray = null;
		try {
			joResult = new JSONObject(tokener);
			jsonArray = joResult.getJSONArray("list");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				resultMap.put(jsonObject.get("name").toString(), jsonObject
						.get("path").toString());
			}
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return resultMap;
	}

}
