package com.bptest.api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadTestData {

	public static String readProperty(String fileName, String key) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\testData\\" + fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prop.getProperty(key);
	}
}
