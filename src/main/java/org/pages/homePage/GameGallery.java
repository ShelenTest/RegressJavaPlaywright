package org.pages.homePage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GameGallery {
    private String nameAllGamesSelector = "._game__info_1w2m1_33 > div > span"; // изменить этот селектор, когжа будут ID
    private String searchInputSelector = "._search-input_gtnc7_46";

    public String getNameFirstGame(Page page){
        Locator games = page.locator(nameAllGamesSelector);
        Locator game = games.nth(0);
        String NameFirstGame = game.textContent();
        return NameFirstGame;
    }

    public String getTextSearchInput(Page page){
        Locator searchInput = page.locator(searchInputSelector);
        page.waitForTimeout(3000);                                //явное ожидание, не знаю, как приладить waitForFunction
        String textSearchInput = searchInput.inputValue();
        return textSearchInput;
    }
}
