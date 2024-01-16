package com.seleniumPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.seleniumPractice.helper.Utility;

public class LoginPage {
	
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By userName= By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/following::input//preceding::input[1]");
	private By password= By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/following::input");
	private By loginButton= By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	public HomePage loginToApplication(String uname,String pass)
	{
		Utility.waitForWebElement(driver, userName).sendKeys(uname);
		Utility.waitForWebElement(driver, password).sendKeys(pass);
		Utility.waitForWebElement(driver, loginButton).click();
		
		HomePage home=new HomePage(driver);
		
		return home;
	}
	
	public boolean isSignInDisplayed()
	{
		return Utility.waitForWebElement(driver, userName).isDisplayed();
	}

}



