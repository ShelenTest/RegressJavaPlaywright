package org.pages.homePage.navBar;

import com.microsoft.playwright.Page;
import org.pages.homePage.navBar.Navbar;

public class NavBarPrivate extends Navbar {
    private String profileButtonSelector = "a.btn-circle.profile";

    public void clickProfileButton (Page page) {
        page.click(profileButtonSelector);
    }
}
