package com.seleniumPractice.testcases;

import com.seleniumPractice.base.BaseClass;
import com.seleniumPractice.dataProvider.DataProviders;
import com.seleniumPractice.pages.AdminPage;
import com.seleniumPractice.pages.HomePage;
import com.seleniumPractice.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseClass
{
	LoginPage login;
	HomePage homePage;
	AdminPage adminPage;

	@Test(dataProvider = "LoginTestData",dataProviderClass = DataProviders.class, priority = 1)
	public void validateLogin(String uname,String pass)
	{
		login=new LoginPage(driver);
		homePage=login.loginToApplication(uname,pass);
		Assert.assertTrue(homePage.isDashboardDisplayed());
	}

	@Test(priority = 2,dependsOnMethods = "validateLogin")
	public void navigateToAdminPage(){
		homePage= new HomePage(driver);
		adminPage=homePage.nagivateToAdminPage();
		Assert.assertTrue(adminPage.isUserManagementDisplayed());
	}

	@Test(dataProvider = "AdminSearchTestData",dataProviderClass = DataProviders.class)
	public void employeeSearchValidation(String uName, String uRole) throws InterruptedException {
		adminPage= new AdminPage(driver);
		adminPage.adminSearch(uName, uRole);
	}
}
