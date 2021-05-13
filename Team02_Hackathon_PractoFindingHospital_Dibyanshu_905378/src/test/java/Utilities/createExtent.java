package Utilities;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class createExtent {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeTest
	public void setUp() {
	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/ExtentReport.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	htmlReporter.config().setDocumentTitle("Hackathon Finding Hospitals");
	htmlReporter.config().setReportName("Practo Testing Report");
	}

	@Test
	public void test1() throws IOException {
	ExtentTest test=extent.createTest("Practo Home Page ","Different services available");
	// log(Status, details)
	    //test.log(Status.INFO, "This step shows presence of Location and Service Box");
	    // info(details)
	    test.info("This step shows the icons and services present in the Practo Home Page");
	    test.pass("This step shows presence of Location and Service Box");
	    test.pass("This step shows presence of Corporate Wellness in Providers dropdown");
	    test.pass("This step shows presence of Diagnostics");
	}

	@Test
	public void test2() throws IOException {
	ExtentTest test=extent.createTest("List of Hospitals","Hospitals with required facilities");
	   // info(details)
	   test.info("This step shows required list of hospitals with required facilities");
	   test.pass("This step shows presence of 24X7 icon");
	   test.pass("This step shows presence of all filters required");
	   test.pass("This step shows list of all hospitals");
	}

	@Test
	public void test3() throws IOException {
	ExtentTest test=extent.createTest("Diagnostics Page","Select city");
	   // info(details)
	   test.info("This step shows the list of Top Cities");
	   test.pass("This step shows presence of list of all top cities");
	}

	@Test
	public void test4() throws IOException {
	ExtentTest test=extent.createTest("Corporate Wellness Page","Health Plans for corporates");
	   // info(details)
	   test.info("This step shows to schedule a demo for corporates for better health plan");
	   test.fail("Test failed-invalid details");
	   }

	@AfterTest
	public void tearDown() {
	extent.flush();
	}

}
