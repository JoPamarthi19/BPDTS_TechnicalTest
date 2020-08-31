package com.bptest.api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static String baseUrl = readProperty("config.properties", "base_url");
	public static String get_city_users_endpoint = readProperty("config.properties", "get_city_users_endpoint");
	public static String get_instrcutions = readProperty("config.properties", "get_instrcutions");
	public static String get_users = readProperty("config.properties", "get_user");
	public static String get_all_users = readProperty("config.properties", "get_all_users");

	public static String readProperty(String fileName, String key) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\config\\" + fileName);
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
