package pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import excelsheet.writeexcel;

public class topcitieslist {
	   WebDriver wd;
	   By var_topcities=By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[3]/ul");
	  
	   static Logger log = LogManager.getLogger("devpinoyLogger");
	   
	   writeexcel s=new writeexcel();
	   
	   
	   		
/*********** To initiate launch browser *****************/
	   
	   
	   public void init2(WebDriver wd) {
	    	this.wd=wd;
	    	
	    	log.info(" ");
}
	   
	   
/******************************* get the list of top cities and print the list in console ***************************/
	   
	   
public void cities() {
	if(wd.findElement(var_topcities).isDisplayed()){
		System.out.println("top cities list  is present");
		
		
		
		
		List<WebElement>data=wd.findElements(var_topcities);
		for(int i=0;i<data.size();i++) {
			System.out.println(data.get(i).getText());
			
		}
		
		System.out.println();
		
	}
	else {
		System.out.println("top cities list is not present");
	}
	
	 log.info("All the sections are verified");
	  log.info("The fields are verified with respect to the xpath ");
	  log.info("The list of top cities are printed successfully");
	  log.info(" ");
	  
}
}