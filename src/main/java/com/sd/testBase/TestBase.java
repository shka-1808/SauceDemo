package com.sd.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.sd.pageLayer.LoginPage;
import com.sd.pageLayer.ProductPage;
import com.sd.utilities.CommonComp;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	public CommonComp c ;
	 
	public LoginPage l;
	public ProductPage p;
	public CommonComp commoncomp;
	
	@BeforeTest
    public void start()
   {
       logger = Logger.getLogger("*CartOpen framework"); //choose-----> org.apache.log4j.Logger
       PropertyConfigurator.configure("logfile.properties");
       
       logger.info("*****************framework execution started*****************");
   }
	
	@AfterTest
    public void end()
   {
   	 logger.info("framework execution finished");
   }
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger.info("browser launched with url");
		
		l = new LoginPage();
		p = new ProductPage();
		c = new CommonComp();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("browser closed");
	}

}
