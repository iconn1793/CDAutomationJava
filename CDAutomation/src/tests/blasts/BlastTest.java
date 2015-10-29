package tests.blasts;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlastTest extends Drivers {

	////////////////////////////////////////
	String account01 = "blasttest01";
	String password01 = account01;

	String account02 = "blasttest02";
	String password02 = account02;

	String account03 = "blasttest03";
	String password03 = account03;

	String blast_url = "www.cyberdust.com";
	String blast_username = "+" + account01;
	////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();

	@Test
	public void test01_sending_text_blasts() throws Exception {
		// Logs into blast testing account
		loginAs.user(account01, password01);

		// Creates a blast list
		blast_lists().click();
		Thread.sleep(2000);
		System.out.println("Creating a blast list");
		try {
			if (driver.findElementById("com.radicalapps.cyberdust:id/blast_groups_list_item_group_indicator").isDisplayed()) {
				blast_list_expand(); // Doesn't need .click() attribute
				blast_list_edit().click();
				blast_list_more().click();
				System.out.println("Deleting pre-existing blast list first");
				delete_list().click();
				confirm().click();
				blast_lists().click();
			}
		} catch (Exception e) {
			
		}
		blast_list_field().sendKeys("List from Blasts tab");
		OK_button().click();
		username(account02).click();
		username(account03).click();
		OK_button().click();
		// Sends text blast with +username, URL, and location to blast list
		System.out.println("Sending text blast to blast list");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
		dust_blast_field().sendKeys(blast_username + " " + blast_url);
		text_location_button().click();
		current_location().click();
		OK_button().click();
		send_to_blast_list().click();
		blast_Ok_button().click();

		// Edits participants and renames blast list
		System.out.println("Editing blast list");
		blast_lists().click();
		blast_list_expand(); // Doesn't need .click(); attribute
		blast_list_edit().click();
		username(account03).click();
		blast_list_more().click();
		rename_list().click();
		rename_blast_list().sendKeys("Edited blast list");
		OK_button().click();
		Thread.sleep(1000);
		OK_button().click();
		back_button().click();
	}

	@Test
	public void test02_sending_photo_blast_01() throws Exception {
		// Sends photo blast with drawing and URL to all followers
		System.out.println("Sending photo blast with drawing and text to all followers");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		photo_button().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		driver.swipe(next_button().getLocation().x + 100, next_button().getLocation().y - 50,
				photo_location_button().getLocation().x + 50, photo_location_button().getLocation().y + 50, 1000);
		add_text().click();
		add_text_field().sendKeys(blast_url);
		done_button().click();
		next_button().click();
		blast_all_followers().click();
		blast_Ok_button().click();
	}

	@Test
	public void test03_sending_photo_blast_02() throws Exception {
		// Sends non public photo blast with +username to the new blast list
		System.out.println("Sending non public photo blast");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		photo_button().click();
		add_text().click();
		add_text_field().sendKeys(blast_username);
		done_button().click();
		next_button().click();
		make_public().click();
		send_to_blast_list().click();
		blast_Ok_button().click();

		// Deletes blast list
		System.out.println("Deleting renamed blast list");
		blast_lists().click();
		blast_list_expand();
		blast_list_edit().click();
		blast_list_more().click();
		delete_list().click();
		confirm().click();
	}

	@Test
	public void test04_sending_giphy_blast() throws Exception {
		// Sends text blast with giphy to a single friend
		System.out.println("Sending giphy");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
		dust_blast_field().sendKeys(":giphy cats");
		OK_button().click();
		blast_friends().click();
		username(account02).click();
		blast_Ok_button().click();
	}

	@Test
	public void test05_sending_video_blast_01() throws Exception {
		// Takes video, adds +username, creates blast list, then sends to that blast list
		System.out.println("Sending video to newly created blast list");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		video_button().click();
		action.longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys(blast_username);
		done_button().click();
		next_button().click();
		create_blast_list().click();
		blast_list_field().sendKeys("My Test List");
		OK_button().click();
		username(account02).click();
		username(account03).click();
		OK_button().click();
		send_to_blast_list().click();
		blast_Ok_button().click();
	}

	@Test
	public void test06_sending_video_blast_02() throws Exception {
		// Takes video, adds URL, then sends to single friend
		System.out.println("Sending video with URL");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_media().click();
		video_button().click();
		action.longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys(blast_url);
		done_button().click();
		next_button().click();
		blast_friends().click();
		username(account02).click();
		blast_Ok_button().click();
	}

	@Test
	public void test07_sending_text_for_replies() throws Exception {
		// Sends text blast for reply test on other account
		System.out.println("Sending text blast for reply test");
		action_menu().click();
		Thread.sleep(1000);
		action_menu_text().click();
		dust_blast_field().sendKeys("Reply test");
		OK_button().click();
		blast_friends().click();
		username(account02).click();
		blast_Ok_button().click();

		// Deletes blast list
		System.out.println("Deleting blast list");
		blast_lists().click();
		blast_list_expand();
		blast_list_edit().click();
		blast_list_more().click();
		delete_list().click();
		confirm().click();
	}

	@Test
	public void test08_opening_text_blast() throws Exception {
		// Login as account02
		loginAs.user(account02, password02);

		// Opens text blast with +username, URL, and location
		System.out.println("Opening text blast and checking +username, URL, and location");
		Thread.sleep(2000);
		name(account01).click(); Thread.sleep(2000);
		swipe_view_location().click(); Thread.sleep(3000);
		driver.pressKeyCode(4); Thread.sleep(2000);
		action.press(sw / 6, sh / 4).release().perform(); // clicks +username
		swipe_view_add().click(); Thread.sleep(2000);
		swipe_view_url_card().click(); Thread.sleep(4000);
		back_button().click(); Thread.sleep(1000);
		
		driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);
	}

	@Test
	public void test09_opening_photo_blast() throws Exception {
		// Opens photo with drawing and URL
		try {
			Thread.sleep(3000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/page_frag_image").isDisplayed()) {
				System.out.println("Image loaded successfully");
			}
		} catch (Exception e) {
			System.out.println("Image did not load");
		}
		swipe_view_text().click();
		Thread.sleep(4000);
		back_button().click();
		Thread.sleep(1000);

		driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);
	}

	@Test
	public void test10_opening_non_public_blast() throws Exception {
		// Opens non public photo blast with +username
		try {
			Thread.sleep(4000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/page_frag_reblast").isDisplayed()) {
				System.out.println("Able to reblast non public blast");
			}
		} catch (Exception e) {
			System.out.println("Not able to reblast non public blast");
		}
		swipe_view_text().click();
		swipe_view_add().click();
		Thread.sleep(1000);

		driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);
	}

	@Test
	public void test11_opening_giphy_blast() throws Exception {
		// Checks if giphy was received
		try {
			Thread.sleep(3000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/page_frag_gif_view").isDisplayed() 
					&& driver.findElementById("com.radicalapps.cyberdust:id/text_overlay").isDisplayed()) {
				System.out.println("Giphy loaded successfully");
			}
		} catch (Exception e) {
			System.out.println("Giphy was not found");
		}
		Thread.sleep(1000);
		driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);
	}

	@Test
	public void test12_opening_video_blast() throws Exception {
		// Opens video with +username
		try {
			Thread.sleep(4000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/overlay_video_view").isDisplayed()) {
				System.out.println("Video loaded successfully");
			}
		} catch (Exception e) {
			System.out.println("Video did not load");
		}
		swipe_view_text().click();
		swipe_view_add().click();
		Thread.sleep(1000);

		driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);

		// Opens video with URL
		swipe_view_text().click();
		Thread.sleep(4000);
		back_button().click();
		Thread.sleep(1000);

		driver.swipe((sw/10*8), (sh/10*3), (sw/10*1), (sh/10*3), 300);
	}

	@Test
	public void test13_reply_to_blast() throws Exception {
		// Opens blast and tests reply functionality
		System.out.println("Testing reply functionality");
		swipe_view_reply().click();
		swipe_view_reply().sendKeys("Test reply");
		swipe_view_reply_send().click();
		swipe_view_reply().click();
		swipe_view_reply().sendKeys("+blasttest");
		
		System.out.println("Testing if +usernames can be tapped");
		swipe_view_reblast().click();
		swipe_view_reply_send().click();
		swipe_view_reply_monkey().click();
		swipe_view_monkey().click();
		swipe_view_emoji_cancel().click();
		swipe_view_reply_media().click();
		
		System.out.println("Testing photo and video replies");
		photo_button().click();
		photo_pen().click();
		driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		swipe_view_photo_send().click();
		swipe_view_reply_media().click();
		video_button().click();
		action.longPress(photo_button(), 5000).release().perform();
		swipe_view_photo_send().click();
		Thread.sleep(4000);
		driver.pressKeyCode(4);
	}

	@Test
	public void test14_checking_blast_replies() throws Exception {
		// Login with account01 to check replies
		loginAs.user(account01, password01);

		// Opens replies from account02 and does a check to see if they were all received
		dusts_tab().click();
		username(account02).click();
		System.out.println("Checking if all replies were successful");
		try {
			Thread.sleep(2000);
			if (driver.findElementById("com.radicalapps.cyberdust:id/chat_bubble_view_message_text").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/emoji_view_image").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/photo_view_image").isDisplayed()
					&& driver.findElementById("com.radicalapps.cyberdust:id/video_play_button").isDisplayed()) {
				System.out.println("All replies successfully received from " + account02);
			}
		} catch (Exception e) {
			System.out.println("All replies were not received");
		}
		Thread.sleep(2000);
		back_button().click();
	}
}
