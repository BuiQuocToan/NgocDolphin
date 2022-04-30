package com.vti.utils.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {
	public static final String RESOURCE = "C:\\Users\\Admin\\Desktop\\Java\\VTI\\Java\\NgocDolphin\\Raiwlay36_TestJavaExam\\src\\main\\resource\\";
	
	private Properties properties;
	
	public DatabaseProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(RESOURCE + "database.properties"));
	}

	public static String getResource() {
		return RESOURCE;
	}

	public String getProperties(String key) {
		return properties.getProperty(key);
	}
	
	
}
