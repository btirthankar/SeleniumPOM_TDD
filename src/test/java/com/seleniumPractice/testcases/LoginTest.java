package com.seleniumPractice.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.seleniumPractice.base.BaseClass;
import com.seleniumPractice.dataProvider.DataProviders;
import com.seleniumPractice.pages.HomePage;
import com.seleniumPractice.pages.LoginPage;

public class LoginTest extends BaseClass
{
	HomePage homePage;
	@Test(dataProvider = "TestData",dataProviderClass = DataProviders.class)
	public void validLogin(String uname,String pass)
	{
		LoginPage login=new LoginPage(driver);

		homePage=login.loginToApplication(uname,pass);
		
		Assert.assertTrue(homePage.isDashboardDisplayed());
		
		homePage.signOutFromApplication();
	
		Assert.assertTrue(login.isSignInDisplayed());
	}
	
	
}
