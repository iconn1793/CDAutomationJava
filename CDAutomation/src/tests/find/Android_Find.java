package tests.find;

import org.openqa.selenium.By;

import elements.AndroidElements;
import elements.LoginWith;
import io.appium.java_client.TouchAction;


public class Android_Find extends AndroidElements {
	
	
	LoginWith loginAs = new LoginWith();
	TouchAction taction = new TouchAction(null);
	
	public void test01_followChatter() throws Exception {
		
		loginAs.user(find_account01, find_password01);
		System.out.println("Logged In");
		
		find_tab().click();
		System.out.println("Width: " + screenWidth + " Height: " + screenHeight + "/nClicking on: " + (screenWidth*0.3) + ", " + (screenHeight*0.68));
		
	
		//follow user from chatter stream
		System.out.println("Following user from chatter stream.");		
		//follow_chatter_icon().click();
		Thread.sleep(800);
		action.longPress(320, 1250).release().perform();
		//Thread.sleep(800);
		//action.longPress(207, 130).release().perform();
		//open_chatter_profile().click();
		boolean followed = ((profile_following().getAttribute("text")).equals("following"));
		System.out.println("Followed from chatter stream: " + followed);
		profile_following().click();
		okay_button().click();
		System.out.println("Chatter unfollowed.");
		other_user_prof_pic().click();		
		
	}
	
	public void test02_chattercategories() throws Exception {
	
		//checking chatter are in correct category
		System.out.println("Checking chatter categories...");
		open_chatter_category_menu();
		business_category().click();		
		System.out.println(CategoryCheck("Business"));
		open_chatter_category_menu();
		chatting_category().click();
		System.out.println(CategoryCheck("Chatting"));
		open_chatter_category_menu();
		entertainment_category().click();
		System.out.println(CategoryCheck("Entertainment"));
		open_chatter_category_menu();
		health_category().click();
		System.out.println(CategoryCheck("Health & Wellness"));
		open_chatter_category_menu();
		music_category().click();
		System.out.println(CategoryCheck("Music"));
		open_chatter_category_menu();
		sports_category().click();
		System.out.println(CategoryCheck("Sports"));
		open_chatter_category_menu();
		startups_category().click();
		System.out.println(CategoryCheck("Start-Ups"));
		open_chatter_category_menu();
		technology_category().click();
		System.out.println(CategoryCheck("Technology"));
				
	}
	
	public void test03_followfeedlist() throws Exception {
		
		//follows a Feed acct
		System.out.println("Checking feed categories...");
		open_chatter_category_menu();
		feed_list().click();
		entertainment_category().click();
		Thread.sleep(900);
		action.press(668, 531).release().perform();//follows first user
		Thread.sleep(900);
		action.press(50, 600).release().perform();//opens profile view
		boolean followed = ((profile_following().getAttribute("name").equals("following")));
		System.out.println("Followed acct from Feed stream: " + followed);
		profile_following().click();
		okay_button().click();
		System.out.println("Feed acct unfollowed.");
		other_user_prof_pic().click();	
		
	}
	
	public void test04_feedList_categories() throws Exception {
		//checks feeds are in right categories
		
		//necessary to reset screen after test03, but not related to user experience
		System.out.println("Checking feed categories...");
		dusts_tab().click();
		find_tab().click();
		
		Thread.sleep(500);
		open_chatter_category_menu();
		feed_list().click();
		entertainment_category().click();
		System.out.println(CategoryCheck("Entertainment"));
		open_chatter_category_menu();
		news_category().click();
		System.out.println(CategoryCheck("News"));
		open_chatter_category_menu();
		sports_category().click();
		System.out.println(CategoryCheck("Sports"));
	}
	
	public void test05_findtab_menus() throws Exception {
		
		System.out.println("Testing menus... (true == pass)");
		get_discovered().click();
		boolean menutest = ((get_discovered_popup().getAttribute("name")).equals("findtester"));
		System.out.println("Get Discovered: " + menutest);
		x_button().click();
		
		people_i_know().click();
		menutest = ((contacts_with_cd().getAttribute("name")).equals("Contacts with Cyber Dust"));
		System.out.println("People I Know: " + menutest);
		addback_button().click();
	}
	
	public void test06_searchbar(){
		/*temp
		loginAs.user(account_name, account_pw);
		System.out.println("Logged In");
		find_tab().click();
		*/
		System.out.println("Testing dynamic search...");
		open_searchbar().click();
		use_searchbar().sendKeys("test");
		driver.findElement(By.name("testacct01"));
		System.out.println("Dynamic search successfull");
		
	}
	private String CategoryCheck (String expectedCategory){
		if ((chatter_category().getAttribute("text")).equals(expectedCategory)){
			return (expectedCategory + " chatters okay");
		}
		else {
			return (expectedCategory + " chatters ERROR");
		}
	}
	
	
	
}
