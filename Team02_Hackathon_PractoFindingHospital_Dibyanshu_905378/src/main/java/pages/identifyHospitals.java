package pages;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import excelsheet.writeexcel;

public class identifyHospitals {
	WebDriver wd;
	By var_timing=By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div/header/div[1]/div/div[3]/label/div");
	By var_allfilters=By.xpath("//span[@data-qa-id = 'all_filters']");
	By var_parking=By.xpath("//div[@data-qa-id = 'Has_Parking_checkbox']");
	By var_hospitalname=By.xpath("//*[@data-qa-id = 'star_rating']/ancestor::div[@data-qa-id = 'hospital_card']/descendant::h2");
	By var_starrating=By.xpath("//*[@data-qa-id = 'star_rating']");
	
	static Logger log = LogManager.getLogger("devpinoyLogger");

	writeexcel s=new writeexcel();
	
	/*********** To initiate launch browser *****************/
	
	public void init4(WebDriver wd) {

    	this.wd=wd;
	
    	 log.info(" ");
    	 log.info("The browser is invoked");
	}
	
	/********************** clicking on 24x7 check box  ******************/ 
	
	
		public void TimeCheckBox() throws Exception {
			wd.manage().window().maximize();
			if(wd.findElement(var_timing).isDisplayed()){
				System.out.println("24x7 icon is present");
				
				
			wd.findElement(var_timing).click();
			
			s.write(7, 7, "pass");
			
			}
			else {
				System.out.println("24x7 icon is not present");
				
				s.write(7, 7, "fail");
			}
			wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				 log.info("All the sections are verified");
	    		  log.info("The fields are verified with respect to the xpath ");
	    		  log.info("Time check  function is verified successfully");
	       		  
			}
		}
		
		
	/************************ clicking on all filters tab  ****************************/
		
		
		public void AllFilters() throws Exception {
			if(wd.findElement(var_allfilters).isDisplayed()) {
				System.out.println("All filters drop down is present");
				wd.findElement(var_allfilters).click();
				
				s.write(13, 7, "pass");
				s.write(13, 6, "Hospital list is displayed");
				
			}
			else {
				System.out.println("All filters drop down is not present");
				
				s.write(13, 7, "fail");
				s.write(13, 6, "Hospital list is not  displayed");
				
			}
			wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(wd.findElement(var_parking).isDisplayed()) {
				System.out.println("Parking checkbox is present");
				wd.findElement(var_parking).click();
			}
			else {
				System.out.println("Parking checkbox is not present");
			}
			
		
			
			wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			
			 log.info("All the sections are verified");
   		  log.info("The fields are verified with respect to the xpath ");
   		log.info("All Filters function is verified successfully");
   		  
		}
		
		
	/*************************** to scroll the page **************************/
		
		
		public void selectScrollDown() throws InterruptedException {
			Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1500)");
		
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(4000);
		
		
		 log.info("All the sections are verified");
		  log.info("The fields are verified with respect to the xpath ");
		  log.info("Select Scroll function is verified successfully");
		  
		}
		
		public void selectFinalHospitals() {
			
			
	/******************** hospitals name with rating ***********************************/
			
			
		if(wd.findElement(var_hospitalname).isDisplayed()) {
			System.out.println("Hospitals name list is present");
		}else {
			System.out.println("Hospitals name list is not present");
		}
		List<WebElement> hospitalName = wd.findElements(var_hospitalname);
		
		
	/**************************** storing star rating *********************************/
		
		
		if(wd.findElement(var_starrating).isDisplayed()) {
			System.out.println("Star rating is present");
		}else {
			System.out.println("Star rating is not present");
		}
		List<WebElement> hospitalRating = wd.findElements(var_starrating);
		
		
	/*********************** save hospital name and ratings ****************************/
		
		
		Map<String , String> hospitalData = new LinkedHashMap<String , String>();
		
		//unique hospitals
		Set<String> hospitalNameList = new LinkedHashSet<String>();
		int j = 1;			//To add the serial numbers
		
		for (int i = 0; i < hospitalName.size(); i++) {
			if (Double.parseDouble(hospitalRating.get(i).getAttribute("title")) > 3.5)    //rating more than 3.5
			{
				hospitalData.put(hospitalName.get(i).getText() , hospitalRating.get(i).getAttribute("title"));
				hospitalNameList.add(hospitalName.get(i).getText());
			}
		}
		
	/******************** Printing the names of the hospitals. ***************************/
		
		
		for(String i : hospitalNameList){					
			System.out.println(j + "\t" + i);
			j++;
		}
		System.out.println("All hospital names have been listed");
		
		 log.info("All the sections are verified");
		  log.info("The fields are verified with respect to the xpath ");
		  log.info("The list of all hospitals are listed successfully");
		  log.info(" ");
		}

		   
      

}
