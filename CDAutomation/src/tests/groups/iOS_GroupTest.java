package tests.groups;

import elements.LoginWith;
import elements.AndroidAlbum;
import io.appium.java_client.TouchAction;

public class iOS_GroupTest extends Android_GroupTest {

	//////////////////////////////////
	String account01 = "grouptest01";
	String password01 = account01;

	String account02 = "grouptest02";
	String password02 = account02;

	String account03 = "grouptest03";
	String password03 = account03;
	
	String blocked_account = "grouptest04";
	/////////////////////////////////

	AndroidAlbum androidAlbum = new AndroidAlbum();
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
    public void test01_create_group() throws Exception {
    	log("Running iOS Test");
//		// Log into account01
//		loginAs.user(account01, password01);
//		
//		// Adds test accounts to group
//    	action_menu().click();
//        action_menu_group().click();
//        username(account02).click();
//        username(account03).click();
//        OK_button().click();
//        groups_title_field().clear();
//        groups_title_field().sendKeys("Test Group");
//        confirm().click();
	}
}
