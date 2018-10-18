package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.PageObjects.CreateAccount;


import base.TestBase;

public class LoginAccount {
	
	public static WebDriver driver = null;
	  
	  @Before
	  public void beforeMethod()
	  {
		 driver=TestBase.OpenBrowser("chrome","Sheet3");
		 
				 	  
	  }
	  
	  @Test
	  public void login()
	  {
		  CreateAccount.loginAccount(driver);
		  //CreateMethod.loginAccount(driver);
	  }
	  

	  @After
	  public void afterMethod()
	  {
		 driver.close();
	  }

}
