package tests.Login;

import elements.IOSElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithTemp extends IOSElements {

	public void loginIOS(String account, String password) {
		
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
            new IOSElements().more_button().click();
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
        	new IOSElements().back_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(new IOSElements().followers()).moveTo(new IOSElements().back_button()).release().perform();
            new IOSElements().logout().click();
            new IOSElements().confirm().click();
        }
        
        if (logged_out && !already_logged_in) {
        	new IOSElements().login_button().click();
        	driver.getKeyboard().sendKeys(account + "\n");
        	new IOSElements().login_password().click();
        	driver.getKeyboard().sendKeys(password + "\n");
        	
        }
    }
}
