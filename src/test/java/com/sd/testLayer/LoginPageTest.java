package com.sd.testLayer;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.sd.pageLayer.LoginPage;
import com.sd.testBase.TestBase;
import com.sd.utilities.CommonComp;
import com.sd.utilities.Utility;

public class LoginPageTest extends TestBase{
	
	@Test(priority = 1)
	public void verifyLoginPageWithValidCredentials() throws InterruptedException
	{
		String expected_result = "Products";
//		String expected_result = "https://www.saucedemo.com/inventory.html";
		LoginPage l = new LoginPage();
		CommonComp c = new CommonComp();
		Utility u = new Utility();
		l.enterUserName("standard_user");
		Thread.sleep(2000);
		l.enterPassword("secret_sauce");
		Thread.sleep(2000);
		l.ClickOnLoginBtn();
		Thread.sleep(2000);
		Utility.getScreenshotMethod("myPicture");
		String actual_result = c.getTextMessageOnHomePage();
//		String actual_result = driver.getCurrentUrl();
		AssertJUnit.assertEquals(actual_result, expected_result);
		
	}
	

	@Test(priority = 2)
	public void verifyLoginPageWithInvalidCredentials() throws InterruptedException
	{
		String actual_result = "Epic sadface: Username and password do not match any user in this service";
		LoginPage l = new LoginPage();
		CommonComp c = new CommonComp();
		l.enterUserName("wrong_user");
		Thread.sleep(2000);
		l.enterPassword("wrong_password");
		Thread.sleep(2000);
		l.ClickOnLoginBtn();
		Thread.sleep(2000);
		Utility.getScreenshotMethod("InvalidPicture_01");
		String expected_result = c.getErrorMessageOnInvalidCredentials();
		AssertJUnit.assertEquals(actual_result, expected_result);
	}
	
	@Test(priority = 3)
	public void verifyLoginPageWithEmptyFields() throws InterruptedException
	{
		String expected_result = "Epic sadface: Username is required";
		
		LoginPage l = new LoginPage();
		CommonComp c = new CommonComp();
		l.enterUserName("");
		Thread.sleep(2000);
		l.enterPassword("");
		Thread.sleep(2000);
		l.ClickOnLoginBtn();
		Thread.sleep(2000);
		Utility.getScreenshotMethod("emptyField_Picture_02");
		String actual_result = c.getErrorMessage();
		AssertJUnit.assertEquals(actual_result, expected_result);	
	}

}
