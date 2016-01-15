package tests.managingFriends;

import org.openqa.selenium.By;

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
	
	String account04 = "friendtest04";
	String password04 = "friendtest04";
	
	String account05 = "friendtest05";
	String password05 = "friendtest05";
	
	String account06 = "friendtest06";
	String password06 = "friendtest06";
	//////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
	// Does a check for blasts from a specified account
	public void checkForBlastsFrom(String account) throws Exception {
    	try {
    		blasts_tab().click();
    		waitTime(1);
    		if (username(account).isDisplayed()) {
    			log("[Warning] Blast received from "+account);
    		}
    	} catch (Exception e) {
    		log ("No blast received from "+account);
    	}
    	waitTime(20);
	}
	
	// Does a check for dusts from a specified account
	public void checkForDustsFrom(String account) throws Exception {
    	try {
    		dusts_tab().click();
    		waitTime(1);
    		if (username(account).isDisplayed()) {
    			log("[Warning] Dust received from "+account);
    		}
    	} catch (Exception e) {
    		log ("No dust received from "+account);
    	}
    	waitTime(20);
	}
	
	// Does a check for a specific account in friends list
	public void checkForFriend(String account) throws Exception {
		try {
			waitTime(1);
			if (username(account).isDisplayed()) {
				log("[Warning] "+account+" is on friends list");
			}
		} catch (Exception e) {
			log(account+" is not on friends list");
		}
		waitTime(20);
	}
	
	// Sends dusts to specified accounts
	public void sendDustsTo(String recipient1, String recipient2) throws Exception {
		blasts_tab();
		action_menu().click();
    	Thread.sleep(500);
    	
    	log("Sending dust to "+recipient1);
    	action_menu_dust().click();
    	username(recipient1).click();
    	chat_room_text_box().clear();
    	chat_room_text_box().sendKeys("Test");
    	chat_room_send_button().click();
    	back_button().click();
    	
    	log("Sending dust to "+recipient2);
    	username(recipient2).click();
    	chat_room_text_box().clear();
    	chat_room_text_box().sendKeys("Test");
    	chat_room_send_button().click();
    	back_button().click();
    	back_button().click();
	}
	
	// Sends blasts to specified accounts
	public void sendBlastsTo(String recipient1, String recipient2) throws Exception {
		blasts_tab();
		action_menu().click();
    	Thread.sleep(500);
    	
		log("Sending blasts to "+recipient1+" and "+recipient2);
    	action_menu_text().click();
       	dust_blast_field().sendKeys("Test");
    	OK_button().click();
    	blast_friends().click();
    	username(recipient1).click();
    	username(recipient2).click();
    	blast_Ok_button().click();
	}
	
	// Checks for friend in friends list then sends blast
	public void checkFriendsThenBlast(String recipient1, String recipient2, String checkForAccount) throws Exception {
		log("Sending blasts to "+recipient1+" and "+recipient2);
		blasts_tab();
		action_menu().click();
    	Thread.sleep(500);
    	action_menu_text().click();
       	dust_blast_field().sendKeys("Test");
    	OK_button().click();
    	blast_friends().click();
    	checkForFriend(checkForAccount);
    	username(recipient1).click();
    	username(recipient2).click();
    	blast_Ok_button().click();
	}

	// Start of test //
    public void test01_blast_for_blasts_tab() throws Exception {
    	loginAs.user(account04, password04);
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blasts to account01 and 02");
    	action_menu_text().click();
    	dust_blast_field().sendKeys("Block/mute from blasts tab");
    	OK_button().click();
    	blast_friends().click();
    	username(account01).click();
    	username(account02).click();
    	blast_Ok_button().click();
    }
    
    public void test02_blast_for_swipe_view() throws Exception {
    	loginAs.user(account05, password05);
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blasts to account01, 02, and 03");
    	action_menu_text().click();
    	dust_blast_field().sendKeys("Block/mute from swipe view");
    	OK_button().click();
    	blast_friends().click();
    	username(account01).click();
    	username(account02).click();
    	username(account03).click();
    	blast_Ok_button().click();
    	
    }
    
    public void test03_block_all_accounts() throws Exception {
    	loginAs.user(account01, password01);

    	// Send account02 blast before blocking
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blast to account02 for testing later");
    	action_menu_text().click();
    	dust_blast_field().sendKeys("Before blocking/muting");
    	OK_button().click();
    	blast_friends().click();
    	username(account02).click();
    	blast_Ok_button().click();
    	
    	// Send account02 dust before blocking
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending dust to account02 for testing later");
    	action_menu_dust().click();
    	name(account02).click();
    	chat_room_text_box().clear();
    	chat_room_text_box().sendKeys("Before blocking");
    	chat_room_send_button().click();
    	back_button().click();
    	
    	// Block account03 from inside dust room
    	log("Blocking account03 from inside dust room");
		name(account03).click();
		dust_three_dotted_menu().click();
		name("block friend").click();
		confirm().click();
    	back_button().click();
    	
    	// Block account02 from Dusts tab
    	log("Blocking account02 from Dusts tab");
    	dusts_tab().click();
    	Thread.sleep(1000);
    	action.press(sw/10*9,(int)Math.round(sh/10*1.8)).release().perform();
    	name("block user").click();
    	confirm().click();
    	
    	// Block account05 from swipe view
    	log("Blocking account05 from swipe view");
    	blasts_tab().click();
    	username(account05).click();
    	blasted_by().click();
    	blasted_by_block().click();
    	confirm().click();
    	
    	// Block account04 from Blasts Tab
    	log("Blocking account04 from Blasts tab");
    	blast_more_button().click();
    	blast_more_block().click();
    	confirm().click();
    	
    	// Block account06 from More / Friends
    	more_button().click();
    	log("Blocking account06 from More/friends menu");
    	friends().click();
    	action.longPress(username(account06), 2000).release().perform();
    	name("block user").click();
    	confirm().click();
    	back_button().click();
//    	Thread.sleep(500);
//    	
//    	// Turns off Blast Previews
//    	driver.swipe((sw/10), (sh/10*7), (sw/10), (sh/10*3), 300);
//		try {
//			if (driver.findElement(By.xpath("//android.widget.Switch[@text='ON' and "
//					+ "@resource-id='com.radicalapps.cyberdust:id/more_fragment_show_preview_switch']")).isDisplayed()) {
//				show_blast_previews().click();
//			}
//		} catch (Exception e) {}
    	back_button().click();
    }
    
    public void test04_message_to_blocked() throws Exception {
    	// Try to send dust to blocked account
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	action_menu_dust().click();
    	
    	for (int i = 2; i <= 6; i++){
	    	try {
	    		waitTime(1);
	    		name("friendtest0"+i).click();
	    		if (chat_room_text_box().isDisplayed()) {
	    			log("[Warning] Opened dust room with blocked user!");
	    		}
	    	} catch (Exception e) {}
    	}
    	log("Cannot start dust with blocked users");
    	back_button().click();
    	
    	// Send blast to blocked accounts
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blast to blocked accounts");
    	action_menu_text().click();
    	dust_blast_field().sendKeys("Test");
    	OK_button().click();
    	blast_all_followers().click();
    	blast_Ok_button().click();
    }
    
    public void test05_mute_all_accounts() throws Exception {
    	loginAs.user(account02, password02);
    	
    	// Mute account01 from Dusts tab
    	log("Muting account01 from Dusts tab");
    	dusts_tab().click();
    	Thread.sleep(1000);
    	action.press(sw/10*9,(int)Math.round(sh/10*1.8)).release().perform();
    	name("mute blasts").click();
    	confirm().click();
    	
    	// Mute account03 from inside dust room
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Muting account03 from inside dust room");
    	action_menu_dust().click();
		name(account03).click();
		dust_three_dotted_menu().click();
		name("mute blasts").click();
		confirm().click();
    	back_button().click();
    	back_button().click();
    	
    	// Mute account05 from swipe view
    	log("Muting account05 from swipe view");
    	blasts_tab().click();
    	Thread.sleep(1000);
    	driver.swipe((sw/10), (sh/10*6), (sw/10), (sh/10*3), 300);
    	username(account05).click();
    	blasted_by().click();
    	blasted_by_mute().click();
    	confirm().click();
    	username(account05).click();
    	swipe_view_exit().click();
    	
    	// Mute account04 from Blasts Tab
    	log("Muting account04 from Blasts tab");
    	Thread.sleep(1000);
    	blast_more_button().click();
    	blast_more_mute().click();
    	confirm().click();
    	username(account04).click();
    	swipe_view_exit().click();
    	
    	// Mute account06 from More / Friends
    	more_button().click();
    	log("Muting account06 from More/friends menu");
    	friends().click();
    	action.longPress(username(account06), 2000).release().perform();
    	name("mute blasts").click();
    	confirm().click();
    	back_button().click();
    	back_button().click();
    }
    
    public void test06_dusts_and_blasts_02() throws Exception {
    	// Send dust to account01
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending dust to "+account01);
    	action_menu_dust().click();
    	username(account01).click();
    	chat_room_text_box().clear();
    	chat_room_text_box().sendKeys("Test");
    	chat_room_send_button().click();
    	back_button().click();
    	back_button().click();
    	
    	// Send blast to account01
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Sending blasts to "+account01);
    	action_menu_text().click();
       	dust_blast_field().sendKeys("Test");
    	OK_button().click();
    	blast_friends().click();
    	username(account01).click();
    	blast_Ok_button().click();
    }
    
    public void test07_unfollow_accounts() throws Exception {
    	loginAs.user(account03, password03);
    	
    	// Unfollow account04 from inside dust room
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
    	log("Unfollowing account04 from inside dust room");
    	action_menu_dust().click();
    	username(account04).click();
    	dust_three_dotted_menu().click();
		name("unfollow").click();
		confirm().click();
		back_button().click();
		
		// Unfollow account05 from swipe view
		log("Unfollowing account05 from swipe view");
		username(account05).click();
		blasted_by().click();
		blasted_by_unfollow().click();
		confirm().click();
		
		// Unfollow account06 from More/friends
    	more_button().click();
    	log("Unfollowing account06 from More/friends menu");
    	friends().click();
    	action.longPress(username(account06), 2000).release().perform();
    	name("unfollow user").click();
    	confirm().click();
    	back_button().click();
    	back_button().click();
    }
    
    public void test08_dusts_and_blasts_03() throws Exception {
    	checkForBlastsFrom(account01);
    	sendDustsTo(account01, account02);
    	sendBlastsTo(account01, account02);
    }
    
    public void test09_dusts_and_blasts_04() throws Exception {
    	loginAs.user(account04, password04);
    	checkForBlastsFrom(account01);
    	sendDustsTo(account01, account02);
    	checkFriendsThenBlast(account01, account02, account03);
    }
    
    public void test10_dusts_and_blasts_05() throws Exception {
    	loginAs.user(account05, password05);
    	checkForBlastsFrom(account01);
    	sendDustsTo(account01, account02);
    	checkFriendsThenBlast(account01, account02, account03);
    }
    
    public void test11_dusts_and_blasts_06() throws Exception {
    	loginAs.user(account06, password06);
    	checkForBlastsFrom(account01);
    	sendDustsTo(account01, account02);
    	checkFriendsThenBlast(account01, account02, account03);
    }
    
    public void test12_check_msg_from_blocked() throws Exception {
    	loginAs.user(account01, password01);
    	for (int i = 2; i <= 6; i++) {
	    	checkForBlastsFrom("friendtest0"+i);
	    	checkForDustsFrom("friendtest0"+i);
    	}
    }
    	
    public void test13_unblock_accounts() throws Exception {
    	// Unblock account02 from More -> friends
    	more_button().click();
    	log("Unblocking account02 from More/friends menu");
    	friends().click();
    	action.longPress(username(account02), 2000).release().perform();
    	name("unblock user").click();
    	back_button().click();
    	
    	// Unblock account03, 04, 05, and 06 from More/muted and blocked users
    	log("Unblocking accounts 03, 04, 05, and 06 from More/muted and blocked users");
    	Thread.sleep(500);
    	action.press(followers()).moveTo(back_button()).release().perform();
    	muted_blocked_users().click();
    	for (int i = 3; i <=6; i++) {
    		username("friendtest0"+i).click();
    	}
    	back_button().click();
    	back_button().click();
    	sendDustsTo(account02, account03);
    	sendBlastsTo(account02, account03);
    }
    
    public void test14_check_msg_from_muted() throws Exception {
    	loginAs.user(account02, password02);
    	
    	// Checks for blasts from muted users
    	boolean mutedBlastsReceived = false;
    	waitTime(1);
    	
    	for (int i = 3; i <= 6; i++) {
    		try {
    			if (username("friendtest0"+i).isDisplayed()) {
    				mutedBlastsReceived = true;
    				log("[Warning] Blast received from muted user friendtest0"+i+"!");
    			}
    		} catch (Exception e) {}
    	}
    	
    	if (!mutedBlastsReceived) {
    		log("No blasts received from muted accounts 03, 04, 05, and 06");
    	}
    	
    	// Checks for dusts from muted users
    	dusts_tab().click();
    	waitTime(1);
    	
    	try {
    		if (name(account01).isDisplayed() && name(account05).isDisplayed() && name(account06).isDisplayed()) {
    			action.press(name(account06)).moveTo(dusts_tab()).release().perform();
    			
    			if (name(account04).isDisplayed() && name(account03).isDisplayed()) {
    				log("Dusts successfully received from all muted users");
    			}
    		} 
    	} catch (Exception e) {
    		log("[Warning] All dusts not received!");
    	}
    }
    
    public void test15_unmute_account01() throws Exception {
    	blasts_tab().click();
    	
    	// Unmute account01 from swipe view
    	log("Unmuting account01 from swipe view");
    	username(account01).click();
    	blasted_by().click();
    	blasted_by_mute().click();
    	
    	try {
    		waitTime(1);
    		if (confirm().isDisplayed()) {
    			log("[Warning] blasted by menu shows incorrect mute status");
    			confirm().click();
        		blasted_by_mute().click();
    		}
    	} catch (Exception e) {}
    	
    	username(account01).click();
    	swipe_view_exit().click();
    	
    	try {
    		waitTime(1);
    		if (username(account01).isDisplayed()) {
    			log("[Warning] blast received from muted user "+account01);
    		}
    	} catch (Exception e) {}
    }
    
    public void test16_unmute_account03_and_04() throws Exception {
    	// Unmute account03 from More/friends
    	more_button().click();
    	log("Unmuting account03 from More/friends menu");
    	friends().click();
    	action.longPress(username(account03), 2000).release().perform();
    	name("unmute blasts").click();
    	back_button().click();

    	// Unmute account04 from More/'muted/blocked users'
    	log("Unmuting account04 from More/muted and blocked users");
    	action.press(followers()).moveTo(back_button()).release().perform();
    	muted_blocked_users().click();
    	username(account04).click();
    	back_button().click();
    	back_button().click();
    }
    
    public void test17_unmute_account05_and_06() throws Exception {
    	dusts_tab().click();
    	
    	waitTime(1);
    	try {
    		if (name("Delete Empty Rooms").isDisplayed()) {
    			action.press(name("Delete Empty Rooms")).moveTo(action_menu()).release().perform();
    		}
    	}catch (Exception e) {}
    	waitTime(20);
    	
    	Thread.sleep(1000);
    	
    	// Unmute account06 from Dusts tab
    	log("Unmuting account06 from Dusts tab");
    	action.press(sw/10*9, sh/10*4).release().perform();
    	name("unmute blasts").click();
    	
    	// Unmute account05 from inside Dust room
    	blasts_tab();
    	action_menu().click();
    	Thread.sleep(500);
		log("Unmuting account05 from inside dust room");
    	action_menu_dust().click();
    	username(account05).click();
    	dust_three_dotted_menu().click();
		name("unmute blasts").click();
		back_button().click();
		back_button().click();
		
		// Delete all dusts
		action.press(name(account06)).moveTo(dusts_tab()).release().perform();
		name("Delete All Dusts").click();
		confirm().click();
    }
    
    public void test18_add_accounts() throws Exception {
    	loginAs.user(account03, account03);
    	blasts_tab();
    	
    	try {
    		waitTime(3);
    		if (name(account01).isDisplayed()) {
    			log("Blast received from account01 after being unblocked");
    			blast_more_button().click();
    			name("delete blast").click();
    		}
    	} catch (Exception e) {
    		log("[Warning] No blasts from account01 after being unblocked!");
    	}
    	
    	dusts_tab().click();
    	
    	try {
    		waitTime(3);
    		if (name(account01).isDisplayed()) {
    			log("Dust received from account01 after being unblocked");
    			action.press(sw/10*9,(int)Math.round(sh/10*1.8)).release().perform();
    			name("delete dust").click();
    		}
    	} catch (Exception e) {
    		log("[Warning] No dusts from account01 after being unblocked!");
    	}
    	
    	waitTime(20);
    	more_button().click();
    	log("Following accounts 04, 05, and 06 again");
    	followers().click();
    	for (int i = 4; i <=6; i++) {
    		name("friendtest0"+i).click();
    	}
    	back_button().click();
    	back_button().click();
    }
}