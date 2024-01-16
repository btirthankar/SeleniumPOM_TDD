package com.seleniumPractice.dataProvider;

import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	
	public static String getProperty(String key) 
	{

		Properties prop=new Properties();
		
		try 
		{
			prop.load(new FileInputStream(new File("./ConfigFiles/Config.properties")));
		} 
		catch (IOException e) {
		
			Reporter.log("LOG:FAIL - Unable to load config file "+e.getMessage());
			
		}
		
		String value=prop.getProperty(key);
		
		return value;
		
	}
	
	
	
}
