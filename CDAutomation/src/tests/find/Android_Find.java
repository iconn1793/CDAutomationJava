package tests.find;

import elements.AndroidElements;
import elements.LoginWith;
import io.appium.java_client.TouchAction;


public class Android_Find extends AndroidElements {
	
	////////////////////////////
	String account_name = "findtester";
	String account_pw = "password";
	////////////////////////////

	LoginWith loginAs = new LoginWith();
	TouchAction taction = new TouchAction(null);
	
	public void test01_chatterdata() throws Exception {
		
		loginAs.user(account_name, account_pw);
		System.out.println("Logged In");
		
		find_tab().click();
		
		//follow user from chatter stream
		System.out.println("Following user from chatter stream.");		
		chatter_category_menu().click();
		art_category().click();
		taction.press(650, 510).release().perform();//follows first user
		taction.press(50, 600).release().perform();//opens profile view
		boolean followed = (profile_following().getAttribute("text").equals("following"));
		System.out.println("Followed from chatter stream: " + followed);
		profile_follow_button().click();
		System.out.println("User unfollowed.");
		
		//
		
		
	}
	
}
