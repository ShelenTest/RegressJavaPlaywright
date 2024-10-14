package orgTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.*;
import org.pages.modals.MoLogin;
import org.pages.Profile;
import org.pages.homePage.navBar.NavBarPrivate;
import org.pages.modals.MoRegistration;
import org.utils.ConfigProperties;
import org.utils.RequestInterception;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends PlaywrightManagerTest{

    private MoLogin moLogin = new MoLogin();
    private NavBarPrivate navBarPrivate = new NavBarPrivate();
    private Profile profile = new Profile();
    private MoRegistration moRegistration = new MoRegistration();
    private RequestInterception requestInterception = new RequestInterception();

    private Page page;

    @BeforeEach
    public void setUp() {
        page = getPage();
        page.navigate(getUrlBase() + "/login");
    }


    @Test
    @DisplayName("MO Login. Успешная авторизация с nickname")
    @Tag("base")
    public void PWC_T13() {
        moLogin.fillLoginInput(page, getLogin());
        moLogin.fillPasswordInput(page, getPassword());
        moLogin.clickLoginButton(page);
        navBarPrivate.clickProfileButton(page);

        Assertions.assertEquals(getLogin(), profile.getUserName(page));
    }

    @Test
    @DisplayName("MO Login. Обработка серверной ошибки 500")
    @Tag("base")
    public void PWC_TEST1() throws JsonProcessingException {    // под этот тест не разработан тест-кейс в зефире
        requestInterception.mock500(page,"**/api/auth/v2/login");
        moLogin.fillLoginInput(page, getLogin());
        moLogin.fillPasswordInput(page, getPassword());
        moLogin.clickLoginButton(page);

        assertThat(page.locator("text=Internal server error")).isVisible();
    }

    @Test
    @DisplayName("МО Login. Переход на МО регистрации по ссылке Register new account")
    @Tag("base")
    public void PWC_T16() {
        moLogin.clickLinkRegisterNewAccount(page);

        assertTrue(page.url().contains("registration"));
        assertThat(moRegistration.findUserNameIcon(page)).isVisible();}

    @Test
    @DisplayName("MO Login. Успешная авторизация с email")
    @Tag("base")
    public void PWC_T14() {
        moLogin.fillLoginInput(page,getEmail());
        moLogin.fillPasswordInput(page,getPassword());
        moLogin.clickLoginButton(page);
        navBarPrivate.clickProfileButton(page);

        Assertions.assertEquals(getEmail(), profile.getEmail(page));}

    @Test
    @DisplayName("МО Login. Авторизация с неверными данными")
    @Tag("base")
    public void PWC_T37() {
        moLogin.fillLoginInput(page,getLogin());
        moLogin.fillPasswordInput(page,"QAZ123");
        moLogin.clickLoginButton(page);

        assertThat(page.getByText("Email or password is wrong")).isVisible();} // переделать ассерт, когда будет id для области ошибки}
}
