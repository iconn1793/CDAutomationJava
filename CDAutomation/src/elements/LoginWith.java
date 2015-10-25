package elements;

import elements.Drivers;

public class LoginWith extends Drivers {
    public void user(String account, String password) {
        boolean already_logged_in;
        boolean logged_out;

        try {
            login_button();  // Change webdriver wait time
            logged_out = true;
        } catch (Exception e) {
            logged_out = false;
        }

        if (!logged_out) {
            more_button().click();
            try {
                name(account);  // Change webdriver wait time
                already_logged_in = true;
            } catch (Exception e) {
                already_logged_in = false;
            }

        if (already_logged_in && !logged_out) {
            System.out.println("Already logged in as " + account);
            back_button().click();
        } else if (!already_logged_in && !logged_out) {
            logged_out = true;
            action.press(followers()).moveTo(back_button()).release().perform();
            logout().click();
            confirm().click();
        }

        if (!already_logged_in && logged_out) {
            System.out.println("Logging in as " + account);
            login_button().click();
            login_username().sendKeys(account);
            login_password().click();
            login_password().sendKeys(password);
            login_OK().click();
        }
        }
    }
}
