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
	
//	private By manageOption=By.xpath("//span[normalize-space()='Manage']");
//
//	private By menu=By.xpath("//img[@alt='menu']");
//
//	private By signOut=By.xpath("//button[normalize-space()='Sign out']");

	private By deashboard=By.xpath("//h6[text()='Dashboard']");

	private By userProfileMenu = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");

	private By logout = By.xpath("//a[text()='Logout']");


	public boolean isDashboardDisplayed()
	{
		boolean status=Utility.waitForWebElement(driver, deashboard).isDisplayed();

		return status;
	}

//	public boolean isManageDisplayed()
//	{
//		 boolean status=Utility.waitForWebElement(driver, manageOption).isDisplayed();
//
//	    return status;
//	}
	
	public void signOutFromApplication()
	{
		
		Utility.waitForWebElement(driver, userProfileMenu).click();
	
		Utility.waitForWebElement(driver, logout).click();

	}
	
	

}
