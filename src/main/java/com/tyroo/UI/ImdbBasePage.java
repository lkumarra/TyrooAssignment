package com.tyroo.UI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImdbBasePage {

	public static WebDriver driver;

	/**
	 * Perform initialization such as launching the browser and entering the URL.
	 * 
	 * @param url Url of the website to launch.
	 */
	public static void initialization(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}

	/**
	 * Perform teardown when execution is completed.
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
