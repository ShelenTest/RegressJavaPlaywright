package org.pages.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.pages.modals.ModalWindow;

public class MoLogin extends ModalWindow {
private String loginInputSelector = "//input[@name='login']";
private String passwordInputSelector = "//input[@name='password']";
private String loginButtonSelector = "button[type='submit']";
private String linkRegisterNewAccountSelector = "Register new account"; //заменить селектор, когда будет ID


    public void fillLoginInput (Page page, String str){
        page.fill(loginInputSelector, str);
    }

    public void fillPasswordInput (Page page, String str) {
        page.fill(passwordInputSelector, str);
    }

    public void clickLoginButton (Page page){
        page.click(loginButtonSelector);
    }
    public Locator getButtonLogin (Page page) {
        Locator buttonLogin = page.locator(loginButtonSelector);
        return buttonLogin;}

    public void clickLinkRegisterNewAccount(Page page){
        page.getByText(linkRegisterNewAccountSelector).click();
    }
}
