package org.pages.homePage.cardGallery;

import com.microsoft.playwright.Page;

public class CardGalleryPublic {

    private String registerCardSelector = ".registration-card";
    private String slideToRightSelector = "//button[@aria-controls='cards-banner-track'][@aria-label='Next slide']";


    public void scrollToRegisterCard(Page page){
        page.waitForTimeout(2000);
        while (true) {
            if (page.locator(registerCardSelector).isVisible()) {
                break;
            }
            page.locator(slideToRightSelector).click();
        }}

}
