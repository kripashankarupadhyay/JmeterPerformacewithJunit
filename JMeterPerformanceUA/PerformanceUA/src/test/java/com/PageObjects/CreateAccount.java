package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.TestBase;
import commonPro.ReadExcel;
import base.ConstantClass;

public class CreateAccount

{
	//WebElement class object define statically
	static By signInButton = By.xpath("//a[contains(text(),'Log In')]");
	static By enterUsername = By.xpath("//input[@id='emailfield']");
	static By enterPassword = By.xpath("//input[@id='passwordfield']");
	static By loginButton = By.xpath("//input[@name='loginbutton']");

	static By GuestUserEmail = By.xpath("(.//*[@id='EmailAddress'])[1]");
	static By GuestCheckout = By.xpath(".//*[@class='btn guestLoginButton']");

	public static void loginAccount(WebDriver driver) 
	{
		try {
			HomePage.PopUp_btn(driver); 

			TestBase.waitFor(5);
			driver.findElement(signInButton).click();
			TestBase.waitFor(4);
			driver.findElement(enterUsername).sendKeys(ReadExcel.getCellData(ConstantClass.TestCase, ConstantClass.UserName));
			driver.findElement(enterPassword).sendKeys(ReadExcel.getCellData(ConstantClass.TestCase, ConstantClass.Password));
			driver.findElement(loginButton).click();
			TestBase.waitFor(2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * Author - Meenal 27 Sep'18
	 */
	public static void GuestUserLoginValidation(WebDriver driver) 
	{
		try {
			TestBase.waitFor(5);
			driver.findElement(GuestUserEmail).sendKeys(ReadExcel.getCellData(ConstantClass.TestCase, ConstantClass.UserName));
			TestBase.waitFor(1);
			driver.findElement(GuestCheckout).click();
			TestBase.waitFor(5);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
