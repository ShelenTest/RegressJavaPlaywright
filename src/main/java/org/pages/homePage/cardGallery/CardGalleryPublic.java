package org.pages.homePage.cardGallery;

import com.microsoft.playwright.Page;

public class CardGalleryPublic {

    private String registerCardSelector = ".registration-card";
    private String slideToRightSelector = "//button[@aria-controls='cards-banner-track'][@aria-label='Next slide']";


    public void scrollToRegisterCard(Page page){
        while (true) {
            page.click(slideToRightSelector);
            if (page.isVisible(registerCardSelector)) {
                break;
            }}}

}
