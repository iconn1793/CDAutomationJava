package tests.reblast;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;

public class Android_ReblastTest extends Drivers {

	//////////////////////////////////
	String account01 = "blasttest01";
	String password01 = account01;
	
	String account02 = "blasttest02";
	String password02 = account02;
	
	String account03 = "blasttest03";
	String password03 = account03;
	//////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
    public void test01_send_text_with_loc () throws Exception {
    	// Login to reblast test accounts
    	loginAs.user(account01, password01);
   
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys("Test");
            text_location_button().click();
            current_location().click();
            OK_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }
	
    public void test02_send_text_no_loc () throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys("Test");
            OK_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }

    public void test03_send_photo_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_media().click();
            photo_button().click();
            photo_location_button().click();
            current_location().click();
            next_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }
    
    public void test04_send_photo_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_media().click();
            photo_button().click();
            next_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }
    

    public void test05_send_giphy_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys(":giphy cats");
            text_location_button().click();
            current_location().click();
            OK_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }

    public void test06_send_giphy_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_text().click();
            dust_blast_field().sendKeys(":giphy cats");
            OK_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }

    public void test07_send_video_with_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            photo_location_button().click();
            current_location().click();
            next_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }
    
    public void test08_send_video_no_loc() throws Exception {
        for (int i = 0; i < 3; i++) {
            action_menu().click();
            action_menu_media().click();
            video_button().click();
            action.longPress(photo_button(), 5000).release().perform();
            next_button().click();
            blast_friends().click();
            username(account02).click();
            blast_Ok_button().click();
        }
    }


    public void test09_reblast_setup() throws Exception {
        loginAs.user(account02, password02);
        blast_lists().click(); 
        Thread.sleep(2000);
        log("Creating a blast list");
        try {
            if (driver.findElementById("com.radicalapps.cyberdust:id/blast_groups_list_item_group_indicator").isDisplayed()) {
                blast_list_expand();  // Doesn't need .click() attribute
                blast_list_edit().click();
                blast_list_more().click();
                log("Deleting pre-existing blast list first");
                delete_list().click();
                confirm().click();
                blast_lists().click();
            }
        } catch (Exception e) {

        }
        blast_list_field().sendKeys("Reblast List");
        OK_button().click();
        username(account01).click();
        username(account03).click();
        OK_button().click();
    }
    
    public void test10_reblast_text_with_loc() throws Exception {
        username(account01).click();
        log("Reblasting text to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting text to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting text to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }


    public void test11_reblast_text_no_loc() throws Exception {
        username(account01).click();
        log("Reblasting text to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting text to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting text to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }

 
    public void test12_reblast_photo_with_loc() throws Exception {
        username(account01).click();
        log("Reblasting photo to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting photo to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting photo to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }


    public void test13_reblast_photo_no_loc() throws Exception {
        username(account01).click();
        log("Reblasting photo to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting photo to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting photo to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }

    public void test14_reblast_giphy_with_loc() throws Exception {
        username(account01).click();
        log("Reblasting giphy to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting giphy to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting giphy to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }

    public void test15_reblast_giphy_no_loc() throws Exception {
        username(account01).click();
        log("Reblasting giphy to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting giphy to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting giphy to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }
    
    public void test16_reblast_video_with_loc() throws Exception {
        username(account01).click();
        log("Reblasting video to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting video to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting video to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }

    public void test17_reblast_video_no_loc() throws Exception {
        username(account01).click();
        log("Reblasting video to all followers");
        swipe_view_reblast().click();
        blast_all_followers().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting video to blast list");
        swipe_view_reblast().click();
        send_to_blast_list().click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.swipe((sw/10*8),(sh/10*3), (sw/10*1), (sh/10*3), 300);
        log("Reblasting video to a friend");
        swipe_view_reblast().click();
        blast_friends().click();
        username(account03).click();
        blast_Ok_button().click();
        swipe_view_reply();
        driver.pressKeyCode(4);
    }

    public void test18_check_reblast_count() throws Exception {
        loginAs.user(account03, password03);
        try {
            if (name("24").isDisplayed()) {
                log("Blast count correct");
                blast_more_button().click();
                blast_more_delete().click();
                log("Deleting blasts");
            }
        } catch (Exception e) {
            log("Blast count incorrect");
        }
    }
}
