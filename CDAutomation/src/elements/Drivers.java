package elements;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Drivers {
	protected static AndroidDriver<WebElement> driver;
	protected static DesiredCapabilities capabilities = new DesiredCapabilities();
	protected WebDriverWait wait = new WebDriverWait(driver, 20);
	protected TouchAction action = new TouchAction(driver);
	
	@BeforeClass
	public static void setUp() throws Exception {
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "");
		capabilities.setCapability("deviceName", "");
		capabilities.setCapability("appPackage", "com.radicalapps.cyberdust");
		capabilities.setCapability("appActivity", "com.radicalapps.cyberdust.activities.LauncherActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	public static AndroidDriver<WebElement> callDriver() {
		return driver;
	}
	
	// Checks if device is Android
	public boolean Android() {
		if (capabilities.getCapability("platformName").equals("Android")) {
			return true;
		} else {
			return false;
		}
	}
	
	// Checks if device is iOS
	public boolean iOS() {
		if (capabilities.getCapability("platformName").equals("iOS")) {
			return true;
		} else {
			return false;
		}
	}
	
	// Prints text to console and to a log file in the project folder / test logs folder
	public void log (String text) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
		String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
		String logLocation = new String();
		
		String dateTime = LocalDateTime.now().format(formatter)+" ";
		String logName = getClass().getPackage().toString().replace("package ", "");
		String testName = ("["+getClass().getSimpleName()+"]: ").replace("Run_", "").replace("Run", "").replace("Android_", "").replace("iOS_", "");
		
		if (projectPath.contains("/")) {
			new File(projectPath+"/testlogs/").mkdir();
			logLocation = projectPath+"/testlogs/"+logName+".log";
		} else {
			new File(projectPath+"\\testlogs\\").mkdir();
			logLocation = projectPath+"\\testlogs\\"+logName+".log";
		}
		
		if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception") 
				|| text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
			System.err.print(dateTime + testName + text + "\n");
		} else {
			System.out.print(dateTime + testName + text + "\n");
		}
		
		FileWriter myWriter = new FileWriter(logLocation, true);
		myWriter.append(dateTime + testName + text + "\n");
		myWriter.close();
	}
	
	// For changing the WebDriverWait time from in a test
	public WebDriverWait waitTime(int x) {
		return wait = new WebDriverWait(driver, x);
	}
	
	//logs out of the current account
	public void logoutAccount() {
		action.press(followers()).moveTo(back_button()).release().perform();
	    logout().click();
	    confirm().click();
	}

/// Common elements ///
    public WebElement name(String name) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
    }
    public WebElement OK_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("OK")));
    }
    public WebElement done_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("done")));
    }
	public WebElement back_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/home")));
	}
	public WebElement confirm() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
	}
	public WebElement cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
	}
	public WebElement profile_follow_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_button")));
	}
	
/// Home page elements /// 	
	public WebElement login_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_screen_login_button")));
	}
	public WebElement login_username() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_frag_username_edit_text")));
	}
	public WebElement login_password() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_frag_password_edit_text")));
	}
	public WebElement login_OK() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/login_frag_ok_button")));
	}
	public WebElement dusts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("DUSTS")));
	}
	public WebElement dust1_more_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='0'][android.widget.ImageView[@index='2' and @resource-id='com.radicalapps.cyberdust:id/more_button']]")));
	}
	public WebElement new_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tap_to_compose_button")));
	}
	public WebElement blasts_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("BLASTS")));
	}
	public WebElement blasted_by() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/profile_button")));
	}
	public WebElement blasted_by_recommend() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_recommend_button")));
	}
	public WebElement blasted_by_mute() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_muteblast_button")));
	}
	public WebElement blasted_by_block() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_mute_button")));
	}
	public WebElement blasted_by_unfollow() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_delete_button")));
	}
	public WebElement blasted_by_report() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/overlay_report_button")));
	}
	public WebElement blast01() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement blast02() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='1' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement blast_more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@index='3' and @resource-id='com.radicalapps.cyberdust:id/more_button']")));
	}
	public WebElement blast_more_mute() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("mute blasts")));
	}
	public WebElement blast_more_delete() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("delete blasts")));
	}
	public WebElement blast_more_block() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("block user")));
	}
	public WebElement blast_more_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("cancel")));
	}
	public WebElement blast_lists() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Blast Lists")));
	}
	public WebElement create_new_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/create_button")));
	}
	public WebElement blast_list_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/name_edit_text")));
	}
	public TouchAction blast_list_expand() {
	    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ExpandableListView[@index='0'][android.widget.RelativeLayout]")));
	    return action.press(el.getLocation().x, el.getLocation().y).release().perform();
	}
	public WebElement blast_list_edit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_groups_list_item_edit_action")));
	}
	public WebElement blast_list_more() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton")));
	}
	public WebElement rename_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Rename list")));
	}
	public WebElement rename_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
	}
	public WebElement delete_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Delete list")));
	}
	public WebElement groups_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("GROUPS")));
	}
	public WebElement groups_title_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0'][android.widget.EditText[@index='0']]")));
	}
	public WebElement group_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='2'][android.widget.ImageButton[@index='0']]")));
	}
	public WebElement group1_more_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='0'][android.widget.ImageView[@index='2' and @resource-id='com.radicalapps.cyberdust:id/more_button']]")));
	}
	public WebElement group1() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement group02() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='1' and @resource-id='com.radicalapps.cyberdust:id/card_view']")));
	}
	public WebElement group_text_field() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_text_box")));
	}
	public WebElement group_text_send() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_send_button")));
	}
	public WebElement group_camera_button() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_photo_button")));
	}
	public WebElement dusting_with() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/btn_chatting_triangle")));
	}
	public WebElement card_view() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/card_view")));
	}
	public WebElement more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='2'][android.widget.ImageView[@index='0']]")));
	}
	public WebElement action_menu() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='1'][android.widget.ImageView[@index='0']]")));
	}
	public WebElement action_menu_dust() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='6'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_group() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='2'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_text() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='3'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_media() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='4'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_discover() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='5'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_search() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='8'][android.widget.ImageView[@index='1']]")));
	}
	public WebElement action_menu_close() throws InterruptedException {
		Thread.sleep(500);
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@index='7'][android.widget.ImageView[@index='0']]")));
	}
	public WebElement dust_blast_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/dust_blast_text_edit_text")));
	}
	public WebElement photo_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_take_picture")));
	}
	public WebElement photo_flip() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_flip_camera")));
	}
	public WebElement photo_pen() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/pen")));
	}
	public WebElement photo_color() {
	    return  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/picker")));
	}
	public WebElement photo_back_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_back")));
	}
	public WebElement video_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("VIDEO")));
	}
	public WebElement photo_location_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/location")));
	}
	public WebElement photo_save_image() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/save_image")));
	}
	public WebElement photo_gallery() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_open_gallery")));
	}
	public WebElement text_location_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/actionbar_blast_pin")));
	}
	public WebElement current_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Current Location")));
	}
	public WebElement add_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_add_text")));
	}
	public WebElement add_text_field() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/edit_text_overlay")));
	}
	public WebElement next_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_next")));
	}
	public WebElement make_public() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_public_button_check")));
	}
	public WebElement blast_all_followers() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_followers_button_plus")));
	}
	public WebElement blast_all_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_friends_button_plus")));
	}
	public WebElement create_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Create Blast List")));
	}
	public WebElement send_to_blast_list() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_check")));
	}
	public WebElement blast_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/blast_tab_friends")));
	}

	public WebElement swipe_view_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/cancel")));
	}
	public WebElement swipe_view_url_card() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='0'][android.widget.LinearLayout[@index='1']]")));
	}
	public WebElement swipe_view_location() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/page_frag_location")));
	}
	public WebElement swipe_view_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/text_overlay")));
	}
	public WebElement swipe_view_reblast() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/page_frag_reblast")));
	}
	public WebElement swipe_view_reply() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_box")));
	}
	public WebElement swipe_view_reply_send() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_send")));
	}
	public WebElement swipe_view_reply_media() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_media")));
	}
	public WebElement swipe_view_reply_monkey() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/reply_monkey")));
	}
	public WebElement swipe_view_monkey() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_image")));
	}
	public WebElement swipe_view_emoji_cancel() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_cancel")));
	}
	public WebElement swipe_view_photo_send() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/action_next")));
	}
	public WebElement swipe_view_exit() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/exit_button")));
	}
	public WebElement username(String user) {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name(user)));
	}
	public WebElement mute_blast_icon() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/mute_blast_icon")));
	}
	public WebElement blast_Ok_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Ok")));
	}
	public WebElement dust_three_dotted_menu() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='2'][android.widget.ImageButton[@index='0']]")));
	}
	public WebElement message_timer() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_timer_view")));
	}
	public WebElement chat_room_text_box() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_text_box")));
	}
	public WebElement chat_room_send_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_send_button")));
	}
	public WebElement sent_text_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_bubble_view_message_text")));
	}
	public WebElement pinned_message() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/pinned_message_text")));
	}
	public WebElement tap_to_unpin_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Tap message to unpin")));
	}
	public WebElement follow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("follow")));
	}
	public WebElement unfollow_from_chat_room() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("unfollow")));
	}
	public WebElement yes_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Yes")));
	}
	
	public WebElement Friend_already_added() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Friend Already Added")));
	}
    
/// More page elements ///
    public WebElement profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_picture")));
    }
    public WebElement remove_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button2")));
    }
    public WebElement change_profile_picture() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
    }
    public WebElement camera_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("Camera")));
    }
    public WebElement profile_picture_done() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/activity_profile_pic_crop_btn")));
    }
    public WebElement enter_bio() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_bio")));
    }
    public WebElement enter_website() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_url")));
    }
    public WebElement share_twitter() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_twitter")));
    }
    public WebElement share_facebook() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_facebook")));
    }
    public WebElement share_instagram() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_instagram")));
    }
    public WebElement share_email() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_share_email")));
    }
    public WebElement followers() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_followers_row")));
    }
    public WebElement friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_friends_row")));
    }
    public WebElement add_friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_row")));
    }
    public WebElement invite_friends() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/invite_friends_row")));
    }
    public WebElement notification_settings() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_push_notification_row")));
    }
    public WebElement easy_search() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_searchable_switch")));
    }
    public WebElement default_to_blasts_tab() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_default_tab_switch")));
    }
    public WebElement sort_dust_list() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_sort_list_switch")));
    }
    public WebElement show_blast_previews() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_show_preview_switch")));
    }
    public WebElement logout() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_logout_row")));
    }
    public WebElement change_email_address() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_email_row")));
    }
    public WebElement change_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_password_row")));
    }
    public WebElement validate_mobile() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_mobile_number_row")));
    }
    public WebElement muted_blocked_users() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_blocked_users_row")));
    }
    public WebElement user_guides() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_guide_row")));
    }
    public WebElement tutorial() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_tutorial_row")));
    }
    public WebElement delete_account() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/more_fragment_delete_account_row")));
    }
    public WebElement enter_old_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_password_fragment_oldpass_edit_text")));
	}
    public WebElement enter_new_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_password_fragment_newpass_edit_text")));
    }
    public WebElement confirm_new_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_password_fragment_newpass_confirm_edit_text")));
    }
    public WebElement change_password_ok_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/spinner_button_text_view")));
    }
    public WebElement new_email_text_box() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/change_email_fragment_newemail_edit_text")));	
    }
    
    public WebElement invalid_username() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.name("Invalid username & password combination")));
    }
    
    public WebElement friends_search() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_fragment_search_box")));
    }
    
    public WebElement chat_room_first_friend() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ListView[@index='0'][android.widget.RelativeLayout[@index='0']]")));
	}
   
    public WebElement delete_dust() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("delete dust")));
	}
    
    public WebElement friends_more_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("more_button")));
	}
    public WebElement friends_list_search() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("home_bottom_bar")));
	}
    public WebElement edit_textbox() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("custom")));
	}
    public WebElement save_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Save")));
	}
    //add friend from followers
    public WebElement add_friend() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("+")));
	}
    
    public WebElement switch_emoji_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/chat_room_fragment_emoji_button")));
	}
    public WebElement switch_text_keyboard() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/emoji_keyboard_fragment_keyboard_button")));
	}
   // public WebElement no_friend() {
	 //   return wait.until(ExpectedConditions.elementToBeClickable(By.name("You don't have any friends yet.?Lets add some!")));
	//}
  //  com.radicalapps.cyberdust:id/emoji_keyboard_fragment_photo_button
    
    
    
    public WebElement okay_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Okay")));
	}
    public WebElement unfollow_button() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("unfollow user")));
	}
    public WebElement search_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.name("Search Friends")));
	}
    
    public WebElement browse_followers() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_followers_row")));
	}
    
    public WebElement browse_friends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/browse_friends_row")));
	}
    
    public WebElement add_friends_search_button_text() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friends_search_button_text")));
	}
    public WebElement add_friends_button_inBrowseFriends() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/add_friend_contacts_listitem_button")));
	}
    
    
    public WebElement discover_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_discover")));
	}
    public WebElement chatters_tab() {
	    return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tab_chatters")));
	}
/// Sign up elements ///
    public WebElement sign_up_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_screen_signup_button")));
    }
    public WebElement pick_username() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_1_username_edit_text")));
    }
    public WebElement create_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_2_password_edit_text")));
    }
    public WebElement confirm_password() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_2_password_confirm_edit_text")));
    }
    public WebElement birthday() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_3_date_edit_text")));
    }
    public WebElement birthday_done() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
    }
    public WebElement email() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_4_email_edit_text")));
    }
    public WebElement sign_up_profile_pic() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_screen_4_1_profile_pic_layout")));
    }
    public WebElement sign_up_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_1_ok_button")));
    }
    public WebElement password_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_2_ok_button")));
    }
    public WebElement birthday_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_3_ok_button")));
    }
    public WebElement email_OK() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/onboarding_4_ok_button")));
    }
    public WebElement skip_button() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("skip")));
    }
    public WebElement date() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.NumberPicker[@index='2'][android.widget.Button]")));
    }
    public WebElement tutorial_image() {
    	return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/tutorial_image")));
    }
}
