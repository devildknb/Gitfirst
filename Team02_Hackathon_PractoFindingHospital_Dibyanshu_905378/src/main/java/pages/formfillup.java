package pages;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import excelsheet.writeexcel;

public class formfillup {
	
	static Logger log = LogManager.getLogger("devpinoyLogger");
	
	
	WebDriver wd;
	
	By var_name=By.id("name");
	By var_organisation=By.id("organization_name");
	By var_email=By.id("official_email_id");
	By var_phoneno=By.id("official_phone_no");
	By var_button=By.id("button-style");
	By var_par=By.xpath("//span[contains(text(),'For Providers')]");
	
	writeexcel f=new writeexcel();
	
	/*********** To initiate launch browser *****************/
	
	  public void init3(WebDriver wd) {
	    	this.wd=wd;
	    	
	    	log.info(" ");
	  }
	  
	  
   /***************** fill up the form and get alert message and handle the alert message  ***************/
	  
	  
		public void form() throws Exception
		{
			
			wd.manage().window().maximize();
			
			try{
				Thread.sleep(5000);
				}
				catch(InterruptedException ie){
				}

			
			
			  FileInputStream fs1 = new FileInputStream ("./testdata/data.properties");
			   	Properties p = new Properties();
			   	p.load(fs1);
			   	
			   	
			
		     
		     

		     
		     
			   	String parent = wd.getWindowHandle();
			     wd.findElement(var_par);
		     
		     Set<String> tabs = wd.getWindowHandles();
				Iterator<String> itr = tabs.iterator();
				while (itr.hasNext()) {
					String child = itr.next();
					if (!parent.equals(child)) {
						wd.switchTo().window(child);
					}
				}
				
				
				try{
					Thread.sleep(5000);
					}
					catch(InterruptedException ie){
					}

		if(wd.findElement(var_name).isDisplayed()) {
		wd.findElement(var_name).sendKeys(p.getProperty("name"));
		System.out.print("name slot is present");}
		else {
			System.out.println("name slot is not present");
		}
				
		
		wd.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		if(wd.findElement(var_organisation).isDisplayed()) {
			
		
		
		wd.findElement(var_organisation).sendKeys(p.getProperty("company"));
		
		System.out.println("organisation slot is present");
		}
		else {
			System.out.println("organisation slot is not present");
		}
		
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		if(wd.findElement(var_email).isDisplayed()) {
			
		
		wd.findElement(var_email)
				.sendKeys(p.getProperty("email"));
		System.out.println("email slot is present");
		}
		else {
			System.out.println("email slot is not present");
		}
		if(wd.findElement(var_phoneno).isDisplayed()) {
		wd.findElement(var_phoneno).sendKeys(p.getProperty("phno"));	//Sending wrong phone number here.
		System.out.println("phone no slot is present");
		}
		else {
			System.out.println("phone no slot is not present");
		}
		
	
		
		if(wd.findElement(var_button).isDisplayed()) {
			System.out.println("button is present");
		
		wd.findElement(var_button).click();
		}
		else {
			System.out.println("button is not present");
		}
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("\n Error Message :");
		System.out.println(wd.switchTo().alert().getText());
		
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert s =wd.switchTo().alert();
		String c= s.getText();
		String d=p.getProperty("alertmessage");
		Assert.assertEquals(c, d);
		
		s.accept();
		
		 f.write(23,7,"pass");
		 f.write(23,6,"Alert message is displayed");
		 
		
		
		
  /****************** Printing the error message received from the alert box. ********************/ 
		   

		  log.info("All the sections are verified");
		  log.info("The fields are verified with respect to the xpath ");
		  log.info("The corporate wellness test is verified successfully");
		  log.info(" ");
		  
		  
		  
		}
		
 /********************* closing browser 
 * @throws Exception ************************************************************/
		
		
		public void closebrowser(WebDriver wd) throws Exception
		{
			wd.quit();
			
			 f.write(25, 7, "pass");
			 f.write(25,6,"Browser closed successfully");
		}
		
		
		
}
		   
	   

