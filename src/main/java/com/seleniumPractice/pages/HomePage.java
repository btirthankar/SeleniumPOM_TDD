package com.seleniumPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumPractice.helper.Utility;

public class HomePage 
{
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By deashboard=By.xpath("//h6[text()='Dashboard']");
	private By userProfileMenu = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By logout = By.xpath("//a[text()='Logout']");

	public boolean isDashboardDisplayed()
	{
		boolean status=Utility.waitForWebElement(driver, deashboard).isDisplayed();
		return status;
	}

	public void signOutFromApplication()
	{
		Utility.waitForWebElement(driver, userProfileMenu).click();
		Utility.waitForWebElement(driver, logout).click();

	}
	
	

}
