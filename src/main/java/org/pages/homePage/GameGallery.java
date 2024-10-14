package org.pages.homePage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GameGallery {
    private String nameAllGamesSelector = "//*[@id=\"scrollGamesContainer\"]/div[4]/div/div/div/div/div/div/div[3]/div[2]/span";  //изменить этот селектор, когжа будут ID
    private String inputSearchSelector = "//input[@placeholder='Search']";

    public String getNameFirstGame(Page page){
        Locator games = page.locator(nameAllGamesSelector);
        Locator game = games.nth(0);
        String NameFirstGame = game.textContent();
        return NameFirstGame;
    }

    public String getTextInputSearch(Page page){
        Locator inputSearch = page.locator(inputSearchSelector);
        page.waitForTimeout(3000);
        String textInputSearch = inputSearch.inputValue();
        return textInputSearch;
    }
}
