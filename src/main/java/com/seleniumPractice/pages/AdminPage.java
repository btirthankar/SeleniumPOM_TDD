package com.seleniumPractice.pages;

import com.seleniumPractice.helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage
{
	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By userManagement = By.xpath("//h6[text()='User Management']");
	private By userRoleDropdown = By.xpath("//label[text()='User Role']//following::div[1]");

	public boolean isUserManagementDisplayed()
	{
		boolean status=Utility.waitForWebElement(driver, userManagement).isDisplayed();
		return status;
	}
}
