package com.sydney.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.sydney.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

 public class BaseClass {
	
	public static Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	//loadConfig method is to load the configuration
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configurations\\config.properties"); // Read from config file
			prop.load(ip);
			System.out.println("Config properties loaded: " + prop);

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		    throw new RuntimeException("Configuration file not found", e);
		} catch (IOException e) {
		    e.printStackTrace();
		    throw new RuntimeException("Failed to load configuration", e);
		}
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	 public void launchApp(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
        	WebDriverManager.chromedriver().clearDriverCache().setup();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		//Launching the URL
		 System.out.println("Launching URL: " + prop.getProperty("WebsiteURL"));
		getDriver().get(prop.getProperty("WebsiteURL"));
	}

	@AfterSuite(groups = { "Smoke", "Regression", "Sanity" })
	public void afterSuite() {
	    if (driver.get() != null) {
	        driver.get().quit();
	        driver.remove(); // Ensure proper cleanup
	    }
	    ExtentManager.endReport();
	}
	
 }
