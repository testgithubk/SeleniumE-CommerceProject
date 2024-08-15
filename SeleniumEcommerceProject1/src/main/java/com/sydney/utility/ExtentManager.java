package com.sydney.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		
		 htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\MyReport.html");
	        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\Extent-config.xml");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        extent.setSystemInfo("HostName", "MyHost");
	        extent.setSystemInfo("ProjectName", "SeleniumEcommerceProject1Project");
	        extent.setSystemInfo("Tester", "Nikita");
	        extent.setSystemInfo("OS", "Win10");
	        extent.setSystemInfo("Browser", "Chrome");
	    }
	    
	    public static void endReport() {
	        extent.flush();
	    }

	}


