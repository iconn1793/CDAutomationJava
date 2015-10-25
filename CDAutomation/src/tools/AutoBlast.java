package tools;

import elements.Drivers;
import io.appium.java_client.TouchAction;
import org.junit.*;


public class AutoBlast extends Drivers {
	String blast_recipient = "bktest01";
	String blast_type = "photo, video, text";  // Use photo, video, text, or a combination of the 3
	String blast_text = "+bkortman +bktest01 +bktest02 \n www.google.com";  // Only works for text blasts
	int number_of_blasts = 3;  // Number of blasts per type
	
	TouchAction action = new TouchAction(driver);
	
    public void photo_blast() {
        action_menu().click();
        action_menu_media().click();
        photo_button().click();
        next_button().click();
        blast_friends().click();
        username(blast_recipient).click();
        blast_Ok_button().click();
    }
    public void video_blast() {
        action_menu().click();
        action_menu_media().click();
        video_button().click();
        action.longPress(photo_button(), 5000).release().perform();
        next_button().click();
        blast_friends().click();
        username(blast_recipient).click();
        blast_Ok_button().click();
    }
    public void text_blast() {
        action_menu().click();
        action_menu_text().click();
        dust_blast_field().sendKeys(blast_text);
        OK_button().click();
        blast_friends().click();
        username(blast_recipient).click();
        blast_Ok_button().click();
    }
    @Test
    public void autoblast() {
    	for (int i = 0; i < number_of_blasts; i++) {
    		
    		if (blast_type.toLowerCase().contains("text".toLowerCase())) {
    			text_blast();
    			System.out.println("Sending text blast: #" + (i+1));
    		}
    		if (blast_type.toLowerCase().contains("photo".toLowerCase())) {
    			photo_blast();
    			System.out.println("Sending photo blast: #" + (i+1));
    	}
    		if (blast_type.toLowerCase().contains("video".toLowerCase())) {
    			video_blast();
    			System.out.println("Sending video blast: #" + (i+1));
    	}
    }
}
    }
