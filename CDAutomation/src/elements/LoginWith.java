package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWith extends Drivers {
	
	public void user(String account, String password) {
		if (Android()) {
			loginAndroid(account, password);
		}
		
		if (IOS()) {
			loginIOS(account, password);
		}
	}

	private void loginAndroid(String account, String password) {
		AndroidElements android = new AndroidElements();
		boolean already_logged_in = false;
        boolean logged_out = false;

        try {
        	//login_button();
        	if (new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_login_button"))).isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
        
        if (!logged_out) {
            android.more_button().click();
            try {
            	//name(account);
            	if (new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.name(account))).isDisplayed()) {
            		already_logged_in = true;
            	}
            } catch (Exception e) {
                already_logged_in = false;
            }
        }
        
        if (already_logged_in && !logged_out) {
        	android.back_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(android.followers()).moveTo(android.back_button()).release().perform();
            android.logout().click();
            android.confirm().click();
        }
        
        if (logged_out && !already_logged_in) {
        	android.login_button().click();
        	android.login_username().sendKeys(account);
        	android.login_password().click();
        	android.login_password().sendKeys(password);
        	android.login_OK().click();
        }
	}
	
	private void loginIOS(String account, String password) {
		IOSElements ios = new IOSElements();
		boolean already_logged_in = false;
        boolean logged_out = false;

        try {
        	//login_button();
        	if (new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.id("login"))).isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
        
        if (!logged_out) {
            ios.more_button().click();
            try {
            	//name(account);
            	if ((driver.findElement(By.name(account)).getAttribute("name")).equals(account)) {
            		already_logged_in = true;
            	}
            } catch (Exception e) {
                already_logged_in = false;
            }
        }
        
        if (already_logged_in && !logged_out) {
        	ios.close_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(ios.followers()).moveTo(ios.close_button()).release().perform();
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
            ios.logout().click();
            ios.confirm().click();
        }
        
        if (logged_out && !already_logged_in) {
        	ios.login_button().click();
          	driver.getKeyboard().sendKeys(account+"\n"+password);
          	ios.login_OK().click();
        }
    }
}
	
