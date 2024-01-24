package com.OrangeHRM.webdriverManager;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

import com.OrangeHRM.utils.Log;
import com.OrangeHRM.utils.WebDriverFactory;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static String ccWebSite = "";
	private static String pcWebSite = "";
	private static String bcWebSite = "";
	private static String cmWebSite = "";

	
	ThreadLocal <String> policyNumberSubmission = new ThreadLocal<>();
	
	public static void setDriver(String browser) {
		try {
			driver.set(WebDriverFactory.get(browser));
		} catch (MalformedURLException e) {
			try {
				Log.exception(e);
			} catch (Exception logException) {
				// TODO Auto-generated catch block
				System.err.println("Exception: " + e.getMessage());	
		}		}
	}
	
	public static WebDriver getDriver() {
		Log.event("WebDriver session: "+driver.get());
		return driver.get();
	}

	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
	
	public static void quitDriver(WebDriver driver) {
		if(driver!=null)
		driver.close();
		//driver.quit();
		DriverManager.driver.remove();
	}
		
	public static synchronized String getCCWebsite() {
		return ccWebSite;
	}
	public static synchronized String getPCwebsite() {
		return pcWebSite;
	}
	public static synchronized String getBCwebsite() {
		return bcWebSite;
	}

	public static synchronized String getCMwebsite() {
		return cmWebSite;
	}

	public static synchronized void setCCWebsite(String CCwebsite) {
		DriverManager.ccWebSite = CCwebsite;
	}
	public static synchronized void setPCWebsite(String PCwebsite) {
		DriverManager.pcWebSite = PCwebsite;
	}
	public static synchronized void setBCWebsite(String BCwebsite) {
		DriverManager.bcWebSite = BCwebsite;
	}
	public static synchronized void setCMWebsite(String CMwebsite) {
		DriverManager.cmWebSite = CMwebsite;
	}

}
