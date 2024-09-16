package com.sd.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.sd.testBase.TestBase;

public class Utility extends TestBase {

	public static void getScreenshotMethod(String filename)
	{
		String path = "C:\\Users\\HP\\Desktop\\sauce_project\\cartOpenProject\\SauceDemo\\screenshot\\";
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path + filename + ".png");
			FileHandler.copy(src, des);
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
