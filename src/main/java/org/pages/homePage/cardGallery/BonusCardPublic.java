package org.pages.homePage.cardGallery;

import com.microsoft.playwright.Page;

public class BonusCardPublic {
    private String buttonClaimBonusSelector = "//article[@class='banner-widget-card deposit-card ']/div/div/div/button";

    public void clickButtonClaimBonus(Page page){
        page.click(buttonClaimBonusSelector);
    }
}
