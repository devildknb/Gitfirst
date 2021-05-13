
package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import excelsheet.writeexcel;

public class diagonstic {
    WebDriver wd;
    By var_diagonsticclick=By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[4]/a/div[2]");
    By var_provider=By.xpath("//span[contains(text(),'For Providers')]");
    By var_corporatewellness=By.xpath("//a[contains(text(),'Corporate wellness')]");
    By var_locationclick=By.xpath("//input[@data-qa-id = 'omni-searchbox-locality']");
	By var_crossclick=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/span[2]/span/i");
	By var_sendlocation=By.xpath("//input[@data-qa-id = 'omni-searchbox-locality']");
	By var_requiredlocationclick=By.xpath("//div[contains(text() , 'Bangalore')]");
	By var_hospitalservice=By.xpath("//input[@data-qa-id = 'omni-searchbox-keyword']");
	By var_serviceclick=By.xpath("//div[text() = 'Hospital']"); 

	static Logger log = LogManager.getLogger("devpinoyLogger");
	
	writeexcel s=new writeexcel();
	
	/****************** To initiate launch of website ***********************/
	
	
    public void init1(WebDriver wd) {
    	this.wd=wd;
    	log.info(" ");
    	  log.info("The browser is invoked");
   }
    
    
	/************************To enter search location************************/
    
    
    
	public void LocationBox() throws IOException {
		wd.manage().window().maximize();
		FileInputStream fs1 = new FileInputStream ("./testdata/data.properties");
	   	Properties p = new Properties();
	   	p.load(fs1);
		
	   	//clicking on location search box
		if(wd.findElement(var_locationclick).isDisplayed()) {
			System.out.println("Practo Home Page is present");
			wd.findElement(var_locationclick).click();
			}
		else {
			System.out.println("Practo Home Page is not present");
		}
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	
 /*************************clicking on x-icon to clear the field****************/
		
		
		if(wd.findElement(var_crossclick).isDisplayed()) {
			System.out.println("x-icon is present");
			wd.findElement(var_crossclick).click();
			}
		else {
			System.out.println("x-icon is not present");
		}
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
			
	/******************** writing in location search box **********************/
		
		
		if(wd.findElement(var_sendlocation).isDisplayed()) {
			wd.findElement(var_sendlocation).sendKeys(p.getProperty("Location"));
			System.out.print("Location slot is present");
			wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
			else {
				System.out.println("Location slot is not present");
			}
	
	/******************* Clicking location box after sending location *********************/
		
		
	wd.findElement(var_requiredlocationclick).click();
	wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	//clicking on search bar
	public void serviceSearchBox() throws Exception {
		FileInputStream fs1 = new FileInputStream ("./testdata/data.properties");
	   	Properties p = new Properties();
	   	p.load(fs1);
		if(wd.findElement(var_hospitalservice).isDisplayed()) {
			wd.findElement(var_hospitalservice).sendKeys(p.getProperty("Search"));
			System.out.println("Service search box is present");
			
			s.write(2, 7, "pass");
			s.write(2, 6, "Hospital list is displayed ");
		}
		else {
			System.out.println("Service search box is not present");
			
			s.write(2, 7, "fail");
			s.write(2, 6, "Hospital list is not  displayed ");
			
		}
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wd.findElement(var_serviceclick).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./screenshot/img1.png"));
		
		
		
		 log.info("All the sections are verified");
		  log.info("The fields are verified with respect to the xpath ");
		  
	}

	
	
	/************************ find diagonstics in home page and click on it  ***********************/
	
	
    public void home() throws Exception {
    	wd.manage().window().maximize();
    	if(wd.findElement(var_diagonsticclick).isDisplayed()) {
System.out.println("Diagnostics page is present");
			
			wd.findElement(var_diagonsticclick).click();
			
			s.write(21, 7, "pass");
			s.write(21, 6, "Top cities list is displayed");
			
			
			//wait
			wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
    		Files.copy(src,new File("./screenshot/img2.png"));
    	}
    	else {
    		System.out.println("Diagnostics page is not present");
    		
    		s.write(21, 7, "fail");
    		s.write(21, 6, "Top cities list is not displayed");
    	}
    		
    		
    		
    		
    		  log.info("All the sections are verified");
    		  log.info("The fields are verified with respect to the xpath ");
    	}
    
    
    //find for provider option in homepage and click on it and then from that click on corporate wellness
	public void provider() throws IOException {
	
		if(wd.findElement(var_provider).isDisplayed()) {
    		System.out.println("for provider is present ");
    		wd.findElement(var_provider).click();
    	}
    	else {
    		System.out.println(" for provider is not present");
    	}
    	if(wd.findElement(var_corporatewellness).isDisplayed()) {
    		System.out.println("corporate wellness is present");
    		wd.findElement(var_corporatewellness).click();
    		  wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		  
    			File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
    			Files.copy(src,new File("./screenshot/img3.png"));
    		  
    		  log.info("All the sections are verified");
    		  log.info("The fields are verified with respect to the xpath ");
    		  
    		  log.info("The Diagonostic page is verified successfully");
    		  log.info(" ");
    	}
		
	}
	
		
	}

