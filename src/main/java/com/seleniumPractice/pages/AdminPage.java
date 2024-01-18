package com.seleniumPractice.pages;

import com.seleniumPractice.helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
	private By searchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	private By userRoleDropdown = By.xpath("//label[text()='User Role']//following::div[1]");
	private By statusEmployeeDropdown = By.xpath("//label[text()='Status']//following::div[1]");
	private By searchResultUserName = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][2]");
	private By getSearchResultUserRole = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][3]");

	private By findTable = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
	//	private By statusEmployeeEnabledDropdown = By.xpath("//label[text()='Status']//following::div[1]");
//	private By statusEmployeeEnabledDropdown = By.xpath("(//div[text()='Enabled'])[1]");
//	private By statusEmployeeDisabledDropdown = By.xpath("(//div[text()='Disabled'])[1]");

	public boolean isUserManagementDisplayed()
	{
		boolean status=Utility.waitForWebElement(driver, userManagement).isDisplayed();
		return status;
	}

	public boolean adminSearch(String userName, String userRole) throws InterruptedException {
		Utility.waitForWebElement(driver, username).sendKeys(userName);
		Utility.waitForWebElement(driver, userrole).click();
		if(userRole.equalsIgnoreCase("Admin")){
			Utility.waitForWebElement(driver, userRoleEmployeeAdminDropdown).click();
		}
		else if(userRole.equalsIgnoreCase("ESS"))
			Utility.waitForWebElement(driver, userRoleEmployeeESSDropdown).click();
		Utility.waitForWebElement(driver, searchButton).click();
		boolean findTableBoolean = Utility.waitForWebElement(driver, findTable).isDisplayed();
		List<WebElement> listofUsers= driver.findElements(searchResultUserName);
		List<WebElement> listofUserRoles= driver.findElements(searchResultUserName);

		if(findTableBoolean){
			for (int i = 0;i<listofUsers.size();i++){
				if(listofUsers.get(i).getText().equals(userName) && listofUserRoles.get(i).getText().equals(userRole))
					return true;
			}
		}
		else
			return false;
		return false;
	}
}
