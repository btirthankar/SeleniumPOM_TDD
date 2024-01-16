package com.seleniumPractice.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider(name = "LoginTestData")
	public static Object [][] getLoginData()
	{
		Object[][]arr=ExcelReader.getDataFromExcel("LoginData");
		return arr;
	}

	@DataProvider(name = "AdminSearchTestData")
	public static Object [][] getAdminSearchData()
	{
		Object[][]arr=ExcelReader.getDataFromExcel("AdminSearchData");
		return arr;
	}
}
