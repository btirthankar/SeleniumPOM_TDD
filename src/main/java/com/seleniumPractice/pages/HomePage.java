package com.seleniumPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumPractice.helper.Utility;

public class HomePage 
{
	WebDriver driver;
	AdminPage adminPage;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By deashboard=By.xpath("//h6[text()='Dashboard']");
	private By userProfileMenu = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By logout = By.xpath("//a[text()='Logout']");

	private By adminButton = By.xpath("//span[text()='Admin']");


	public boolean isDashboardDisplayed()
	{
		boolean status=Utility.waitForWebElement(driver, deashboard).isDisplayed();
		return status;
	}

	public AdminPage nagivateToAdminPage(){
		Utility.waitForWebElement(driver, adminButton).click();
		adminPage=new AdminPage(driver);
		return adminPage;
	}

	public void logOutFromApplication()
	{
		Utility.waitForWebElement(driver, userProfileMenu).click();
		Utility.waitForWebElement(driver, logout).click();

	}
	
	

}
