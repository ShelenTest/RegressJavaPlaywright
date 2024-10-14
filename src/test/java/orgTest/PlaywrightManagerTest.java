package orgTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.utils.ConfigProperties;
import org.utils.ConfigProperties;

public abstract class PlaywrightManagerTest {
    private Playwright playwright;
    private Browser browser;
    private  Page page;
    private String skinName = "cb";


    @BeforeEach
    public void setUP() {
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
     // options.setHeadless(false); // Установка режима Headless в 'false', чтобы браузер был видим
        browser = chromium.launch(options);
        page = browser.newPage();
        Page.NavigateOptions navigateOptions = new Page.NavigateOptions().setWaitUntil(WaitUntilState.COMMIT); // если будут проблемы с ожиданиями, можно попробовать DOMCONTENTLOADED вместо COMMIT
        String envSkinName = System.getProperty("skinName");
        skinName = (envSkinName != null) ? envSkinName : skinName;
        page.navigate(getUrlBase(), navigateOptions);
    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }
    public  Page getPage() {
        return page;
    }

    public String getUrlBase(){
        return ConfigProperties.getProperty(skinName+".urlBase");
    }
    public String getUrlLogSmsEmail(){
        return ConfigProperties.getProperty(skinName+".urlLogSmsEmail");
    }
    public String getLogin(){
        return ConfigProperties.getProperty(skinName+".login");
    }
    public String getEmail(){
        return ConfigProperties.getProperty(skinName+".email");
    }
    public String getPassword(){
        return ConfigProperties.getProperty(skinName+".password");
    }
    public String getUrlForGame(){
        return ConfigProperties.getProperty(skinName+".urlForGame");
    }
}
