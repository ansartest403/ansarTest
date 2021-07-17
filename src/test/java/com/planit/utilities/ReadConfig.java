package com.planit.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.planit.Base.BaseClass;

public class ReadConfig {

	Properties properties;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fileInputStream = new FileInputStream(src);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception message) {
			BaseClass.logger.info(message.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=properties.getProperty("baseURL");
		return url;
	}
	
	public String getExcelPath()
	{
		String path=properties.getProperty("excelFilePath");
		return path;
	}
	
	public String getExcelSheetName()
	{
		String sheet=properties.getProperty("excelSheet");
		return sheet;
	}
	
	public String getChromePath()
	{
	String chromepath=properties.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=properties.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=properties.getProperty("firefoxpath");
	return firefoxpath;
	}

	
}




