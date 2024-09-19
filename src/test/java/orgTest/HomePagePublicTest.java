
package orgTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.*;
import org.pages.homePage.GameGallery;
import org.pages.homePage.RegisterForm;
import org.pages.homePage.cardGallery.BonusCardPublic;
import org.pages.homePage.cardGallery.CardGalleryPublic;
import org.pages.homePage.cardGallery.RegisterCard;
import org.pages.modals.MoLogin;
import org.pages.modals.MoRegistration;
import org.utils.ConfigProperties;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePagePublicTest extends PlaywrightManagerTest {

private MoRegistration moRegistration = new MoRegistration();
private MoLogin moLogin = new MoLogin();
private GameGallery gameGallery = new GameGallery();
private RegisterForm registerForm = new RegisterForm();
private CardGalleryPublic cardGalleryPublic = new CardGalleryPublic();
private RegisterCard registerCard = new RegisterCard();
private BonusCardPublic bonusCardPublic = new BonusCardPublic();
private Page page;


    @BeforeEach
    public void init(){
    page = getPage();}

    @Test
    @DisplayName("Главная страница. Фильтры. Переход по прямой ссылке с фильтром для конкретной игры")
    @Tag("base")
    public void PWC_T185() {
        Page.NavigateOptions navigateOptions = new Page.NavigateOptions().setWaitUntil(WaitUntilState.COMMIT);
        page.navigate(ConfigProperties.getProperty("urlForGame"),navigateOptions);

        assertEquals(gameGallery.getTextSearchInput(page),("\"" + gameGallery.getNameFirstGame(page) + "\""));
    }

    @Test
    @DisplayName("Главная страница. Card Gallery. Registration card. Переход на МО регистрации по кнопке Create account с незаполненными полями")
    @Tag("cards")
    public void PWC_T21() {
        cardGalleryPublic.scrollToRegisterCard(page);
        registerCard.clickCreateAccount(page);

        assertThat(moRegistration.findUserNameIcon(page)).isVisible();
        assertTrue(page.url().contains("registration"));
    }

    @Test
    @DisplayName("Главная страница. Card gallery. Registration card. Переход на МО регистрации по кнопке Create account с заполненными полями")
    @Tag("cards")
    public void PWC_T22() {
        cardGalleryPublic.scrollToRegisterCard(page);
        registerCard.fillUserNameInput(page,"Test name");
        registerCard.fillEmailInput(page,"Test email");
        registerCard.fillPasswordInput(page,"Password");
        registerCard.fillBonusCodeInput(page,"Test code");
        registerCard.clickCreateAccount(page);

        Assertions.assertEquals(moRegistration.getValueUserName(page),"Test name");
        Assertions.assertEquals(moRegistration.getValueEmail(page),"Test email");
        Assertions.assertEquals(moRegistration.getValuePassword(page),"Password") ;
        Assertions.assertEquals(moRegistration.getValueBonusCode(page),"Test code");
    }


    @Test
    @DisplayName("Главная страница. Registration form. Переход на МО регистрации по кнопке Get Bonus с незаполненными полями")
    @Tag("cards")
    public void PWC_T19() {
        registerForm.clickGetBonusButton(page);

        assertThat(moRegistration.findUserNameIcon(page)).isVisible();
        assertTrue(page.url().contains("registration"));
    }

    @Test
    @DisplayName("Главная страница. Registration form. Переход на МО регистрации по кнопке Get Bonus с заполненными полями")
    @Tag("cards")
    public void PWC_T20() {
        registerForm.fillUserNameInput(page,"Test name");
        registerForm.fillEmailInput(page,"Test email");
        registerForm.fillPasswordInput(page,"Password");
        registerForm.fillBonusCodeInput(page,"Test code");
        registerForm.clickGetBonusButton(page);

        Assertions.assertEquals(moRegistration.getValueUserName(page),"Test name");
        Assertions.assertEquals(moRegistration.getValueEmail(page),"Test email");
        Assertions.assertEquals(moRegistration.getValuePassword(page),"Password") ;
        Assertions.assertEquals(moRegistration.getValueBonusCode(page),"Test code");
    }


    @Test
    @DisplayName("Главная страница. Card gallery. Кнопка Claim bonus на карточке переводит неавторизованного игрока на МО Login")
    @Tag("cards")
    public void PWC_T164() {
       bonusCardPublic.clickButtonClaimBonus(page);

        assertThat(moLogin.getButtonLogin(page)).isVisible();
        assertTrue(page.url().contains("login"));
    }
    }

