package org.pages.homePage.navBar;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.pages.homePage.navBar.Navbar;

public class NavBarPublic extends Navbar {

private String loginButtonSelector = ".right-panel button.btn-primary";
    public void loginButtonClick(Page page){
        Locator loginButton = page.locator(loginButtonSelector);
        loginButton.click();
    }

}
