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
	LoginPage login;
	@Test(dataProvider = "LoginTestData",dataProviderClass = DataProviders.class)
	public void validateLogin(String uname,String pass)
	{
		login=new LoginPage(driver);
		homePage=login.loginToApplication(uname,pass);
		Assert.assertTrue(homePage.isDashboardDisplayed());
		login= homePage.logOutFromApplication();
		Assert.assertTrue(login.isSignInDisplayed());
	}
}