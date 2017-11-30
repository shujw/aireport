package com.gotourl;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import com.test.Test;

/**
 * @author liuyazhuang
 * @time 2015-10-22
 * 
 */
public class GotoUrl {

	/**
	 * 打开IE浏览器访问页面
	 */
	// public static void openIEBrowser() {
	// // 启用cmd运行IE的方式来打开网址。
	// String str = "cmd /c start iexplore http://blog.csdn.net/l1028386804";
	// try {
	// Runtime.getRuntime().exec(str);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 打开默认浏览器访问页面
	 */
	// public static void openDefaultBrowser() {
	// // 启用系统默认浏览器来打开网址。
	// try {
	// // URI uri = new URI("http://blog.csdn.net/l1028386804");
	// URI uri = new URI(
	// "http://192.168.0.126:8075/WebReport/ReportServer?reportlet=doc%2FJS%2F%5B81ea%5D%5B5b9a%5D%5B4e49%5D%5B5bfc%5D%5B51fa%5D%5B6587%5D%5B4ef6%5D%5B540d%5D%5B79f0%5D.cpt");
	// Desktop.getDesktop().browse(uri);
	// } catch (URISyntaxException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 打开默认浏览器访问页面
	 */
	public Map<String, String> openDefaultBrowser(List<String> cmd) {
		String baseURI = "http://192.168.0.126:8075/WebReport/ReportServer?";
		FindReport fr = new FindReport();
		Map<String, String> resultMap = fr.findReport(cmd);
		String reportPath = "";
		if (resultMap.isEmpty() == false) {
			String tmp = resultMap.entrySet().iterator().next().getValue();
			if (tmp.contains(".cpt")) {
				reportPath = "reportlet=" + tmp;
			}
			
			if (tmp.contains(".frm")) {
				reportPath = "formlet=" + tmp;
			}
		}
		String URI = baseURI + reportPath;

		// 启用系统默认浏览器来打开网址。
		try {
			// URI uri = new URI("http://blog.csdn.net/l1028386804");
			URI uri = new URI(URI);
			Desktop.getDesktop().browse(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}

	// public static void main(String[] args) {
	// // openIEBrowser();
	// openDefaultBrowser();
	// }
}