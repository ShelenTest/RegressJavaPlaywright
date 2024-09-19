package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Profile {
    private String emailInputSelector = "//input[@id='mui-4']";

public String getUserName(Page page) {
    Locator inputs = page.locator("input");
    String userNameProfile = inputs.nth(2).getAttribute("value");
    return userNameProfile;
}

public String getEmail(Page page) {
    String emailProfile = page.locator(emailInputSelector).getAttribute("value");
    return emailProfile;
}
}
