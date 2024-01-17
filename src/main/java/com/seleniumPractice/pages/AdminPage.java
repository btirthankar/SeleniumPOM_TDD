package com.seleniumPractice.pages;

import com.seleniumPractice.helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminPage
{
	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By userManagement = By.xpath("//h6[text()='User Management']");
	private By username = By.xpath("//label[text()='Username']//following::input[1]");
	private By userrole = By.xpath("(//*[text()='-- Select --'])[1]");
	private By userRoleEmployeeAdminDropdown = By.xpath("(//*[text()='Admin'])[3]");
	private By userRoleEmployeeESSDropdown = By.xpath("(//*[text()='ESS'])[1]");
	private By userRoleDropdown = By.xpath("//label[text()='User Role']//following::div[1]");
	private By statusEmployeeDropdown = By.xpath("//label[text()='Status']//following::div[1]");
//	private By statusEmployeeEnabledDropdown = By.xpath("//label[text()='Status']//following::div[1]");
//	private By statusEmployeeEnabledDropdown = By.xpath("(//div[text()='Enabled'])[1]");
//	private By statusEmployeeDisabledDropdown = By.xpath("(//div[text()='Disabled'])[1]");

	public boolean isUserManagementDisplayed()
	{
		boolean status=Utility.waitForWebElement(driver, userManagement).isDisplayed();
		return status;
	}

	public void employeeSearch(String userName, String userRole) throws InterruptedException {
		Utility.waitForWebElement(driver, username).sendKeys(userName);
		Utility.waitForWebElement(driver, userrole).click();
		if(userRole.equalsIgnoreCase("Admin")){
			Utility.waitForWebElement(driver, userRoleEmployeeAdminDropdown).click();
			Assert.assertTrue(Utility.waitForWebElement(driver, userRoleEmployeeAdminDropdown).isDisplayed());
			System.out.println("*******************Admin**************************");
			Thread.sleep(3000);

		}
		else
			Utility.waitForWebElement(driver, userRoleEmployeeESSDropdown);
		System.out.println("*******************Not getting link**************************");

	}
}
