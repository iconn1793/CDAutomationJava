package tests.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.LoginWith;
import elements.AndroidCamera;
import elements.AndroidElements;

public class Android_TutorialTest extends AndroidElements {

	String account_name = "tutorialtest";
	String account_pw = "password";

	AndroidCamera androidCamera = new AndroidCamera();
	LoginWith loginAs = new LoginWith();
	
	
	public void test01_tutorialUI() throws Exception
	{
		int x =0 ;
		loginAs.user(account_name, account_pw);
		Thread.sleep(5000);
		
		more_button().click();
		 action.press(followers()).moveTo(back_button()).release().perform();
		 tutorial_button().click();
		 Thread.sleep(1000);
		 WebElement replay = wait.until(ExpectedConditions.elementToBeClickable(By.name("replay")));
		 WebElement exit = wait.until(ExpectedConditions.elementToBeClickable(By.name("exit")));
		 try{
			 if((replay.isDisplayed())&&((exit.isDisplayed())))
			 {
				 log("Tutorial UI is displayed");
			 }
		 }
		 catch(Exception e)
		 {
			 log("Tutorial UI is not displayed properly");
		 }
		
	}
	
	public void test02_tutorialFunctionality() throws Exception
	{
		WebElement replay = wait.until(ExpectedConditions.elementToBeClickable(By.name("replay")));
		 WebElement exit = wait.until(ExpectedConditions.elementToBeClickable(By.name("exit")));
		
		 replay.click();
		 exit.click();
		 
		 try{
			 if((!replay.isDisplayed())&&((!exit.isDisplayed())))
			 {
				 log("Tutorial UI is displayed");
			 }
		 }
		 catch(Exception e)
		 {
			 log("Tutorial UI is not displayed properly");
		 }
	
	
	}
	
}