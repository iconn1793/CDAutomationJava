package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.Drivers;

public class LoginWith extends Drivers {
	
    public void user(String account, String password) throws Exception {
        boolean already_logged_in = false;
        boolean logged_out = false;

        try {
        	//login_button();
        	if (new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.id("com.radicalapps.cyberdust:id/splash_screen_login_button"))).isDisplayed()) {
            	logged_out = true;
            	already_logged_in = false;
        	}
        } catch (Exception e) {
            logged_out = false;
        }
      
        if (!logged_out) {
            more_button().click();
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
            back_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(followers()).moveTo(back_button()).release().perform();
            logout().click();
            confirm().click();
        }
        
        if (logged_out && !already_logged_in) {
            login_button().click();
            login_username().sendKeys(account);
            login_password().click();
            login_password().sendKeys(password);
            login_OK().click();
        }
    }
}
