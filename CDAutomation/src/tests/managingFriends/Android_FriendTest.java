package tests.managingFriends;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;

public class Android_FriendTest extends Drivers {

	//////////////////////////////////
	String account01 = "friendtest01";
	String password01 = "friendtest01";
	
	String account02 = "friendtest02";
	String password02 = "friendtest02";
	
	String account03 = "friendtest03";
	String password03 = "friendtest03";
	//////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
    public void test01_dustsTab () throws Exception {
//    	loginAs.user(account01, password01);
    	dusts_tab().click();
//    	action_menu().click();
//    	action_menu_dust().click();
//    	name(account02).click();
//    	chat_room_text_box().clear();
//    	chat_room_text_box().sendKeys("Test");
//    	chat_room_send_button().click();
//    	back_button().click();
//    	back_button().click();

    	Thread.sleep(2000);
    	action.press(sw/10*9,(int)Math.round(sh/10*1.7)).release().perform();
    }
    
    public void test02 () throws Exception {
    	 
    }
}