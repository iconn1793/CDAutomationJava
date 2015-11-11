package Sandbox;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;

public class Android_Template extends Drivers {

	//////////////////////////////////
	String account01 = "";
	String password01 = "";

	String account02 = "";
	String password02 = "";

	String account03 = "";
	String password03 = "";
	//////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();

    public void test01 () throws Exception {
    	 
    }
    
    public void test02 () throws Exception {
    	 
    }
}