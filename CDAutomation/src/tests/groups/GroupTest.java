package tests.groups;

import org.junit.*;
import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupTest extends Drivers {

	//////////////////////////////////
	String account01 = "grouptest01";
	String password01 = account01;

	String account02 = "grouptest02";
	String password02 = account02;

	String account03 = "grouptest03";
	String password03 = account03;
	
	String blocked_account = "grouptest04";
	/////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	@Test
    public void test01_create_group() throws Exception {
		// Adds test accounts to group
//    	action_menu().click();
//        action_menu_group().click();
//        username(account02).click();
//        username(account03).click();
//        OK_button().click();
//        cancel().click();
//        OK_button().click();
//        groups_title_field().click();
//        groups_title_field().sendKeys("Test Group");
//        confirm().click();
//        back_button().click();
		
        // Tries to add blocked account to group
//		groups_tab().click();
//		// Group more button
//        action.press(group01().getLocation().x+954, group01().getLocation().y+80).release().perform();
//        name("add friends to room").click();
//        name(blocked_account).click();
//		try {
//			OK_button().click();
//			System.out.println("Added blocked user to group!");
//		} catch (Exception e) {
//			System.out.println("Could not add blocked user to group");
//		}
        
		groups_tab().click();
		group01().click();
//		group_text_field().clear();
//		group_text_field().sendKeys("+bktest");
//		
//		// Taps on +username
//		action.press(group_text_field().getLocation().x+300, group_text_field().getLocation().y-50).release().perform();
//		group_text_send().click();
//		
//		// Text
//		group_text_field().sendKeys("Hello test group");
//		group_text_send().click();
//		
//		// Photo
//		group_camera_button().click();
//		photo_button().click();
//		photo_pen().click();
//		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
//				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
//		photo_color().click();
//		driver.swipe(next_button().getLocation().x + 100, next_button().getLocation().y - 50,
//				photo_save_image().getLocation().x + 50, photo_save_image().getLocation().y + 50, 1000);
//		add_text().click();
//		add_text_field().sendKeys("www.cyberdust.com");
//		done_button().click();
//		next_button().click();
//		
//		// Giphy
//		group_text_field().sendKeys(":giphy cats");	
//		group_text_send().click();
		
		// Photo from gallery
		group_camera_button().click();
		photo_gallery().click();
		Thread.sleep(2000);
		driver.findElementById("com.android.documentsui:id/grid").click(); // x = +150 y = +100
    }
}
