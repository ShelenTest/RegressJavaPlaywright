package orgTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.utils.ConfigProperties;

public abstract class PlaywrightManagerTest {
    private Playwright playwright;
    private Browser browser;
    private  Page page;


    @BeforeEach
    public void setUP() {
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
       // options.setHeadless(false); // Установка режима Headless в 'false', чтобы браузер был видим
        browser = chromium.launch(options);
        page = browser.newPage();
        Page.NavigateOptions navigateOptions = new Page.NavigateOptions().setWaitUntil(WaitUntilState.COMMIT); // если будут проблемы с ожиданиями, можно попробовать DOMCONTENTLOADED вместо COMMIT
        page.navigate(ConfigProperties.getProperty("urlBase"), navigateOptions);
    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }
    public  Page getPage() {
        return page;
    }
}
