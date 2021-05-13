package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import excelsheet.writeexcel;
import pages.diagonstic;
import pages.formfillup;
import pages.identifyHospitals;
import pages.topcitieslist;

public class testfindhospital {

	static Logger log = LogManager.getLogger("devpinoyLogger");

	WebDriver wd = null;
	diagonstic a = new diagonstic();
	topcitieslist b = new topcitieslist();
	formfillup c = new formfillup();
	identifyHospitals d = new identifyHospitals();
	
	writeexcel s=new writeexcel();

	@Parameters("BrowserName")
	@BeforeClass
	
	
	
	/***************************** launch browser *****************************************/

	public void setdriver(String BrowserName) {

		try {

			System.out.println("Browser name is " + BrowserName);
			if (BrowserName.equalsIgnoreCase("Firefox")) {

				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				wd = new FirefoxDriver();
				
			} else if (BrowserName.equalsIgnoreCase("Chrome")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);

				ChromeOptions op = new ChromeOptions();
				op.merge(cap);

				String hubURL = "http://10.17.5.127:4444/wd/hub";
				wd = new RemoteWebDriver(new URL(hubURL), op);
				
				
				

				log.info("Set Driver function is successfull");

			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	@Test(priority = 1)
	public void launchbrowser() throws Exception {

		a.init1(wd);

		FileInputStream fs1 = new FileInputStream("./testdata/data.properties");
		Properties p = new Properties();
		p.load(fs1);

		wd.get(p.getProperty("URL"));
		
		s.write(1,7,"pass");
		s.write(1, 6, "User is able to invoke ");
		

		String a = wd.getTitle();

		String b = p.getProperty("pagetittle");
		
		
		Assert.assertEquals(a, b);

	}

	@Test(priority = 2)
	public void location() throws Exception {
		try {
			a.LocationBox();
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			a.serviceSearchBox();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void search() throws Exception {
		d.init4(wd);
		d.TimeCheckBox();
		d.AllFilters();
		try {
			d.selectScrollDown();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		d.selectFinalHospitals();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		wd.navigate().back();
		wd.navigate().back();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wd.navigate().back();

	}

	@Test(priority = 4)
	public void clickondiagostic() throws Exception {
		a.init1(wd);
		a.home();

	}

	@Test(priority = 5)
	public void gettopcitieslist() {
		b.init2(wd);
		b.cities();
		// navigate back
		wd.navigate().back();

	}

	@Test(priority = 6)
	public void corporatewellness() throws IOException {
		a.init1(wd);
		a.provider();

	}

	@Test(priority = 7)
	public void fillup() throws Exception {
		c.init3(wd);
		try {
			c.form();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	@Test(priority=8)
	public void quitbrowser() throws Exception
	{
		c.closebrowser(wd);
	}

}
