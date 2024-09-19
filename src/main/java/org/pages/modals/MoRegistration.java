package org.pages.modals;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MoRegistration extends ModalWindow {
    private String userNameInputSelector = "//input[@id='nickName']";
    private String emailInputSelector = "//input[@id='email']";
    private String passwordInputSelector = "//input[@id='password']";
    private String bonusCodeInputSelector = "//input[@id='bonusCode']";
    private String userNameIconSelector = "PersonOutlinedIcon";
    private String createAccountButton = ".MuiButton-containedSizeLarge";

    public Locator findUserNameIcon(Page page){
        Locator userNameIcon = page.getByTestId(userNameIconSelector);
        return userNameIcon;
    }
    public String getValueUserName (Page page){
        String valueUserName = page.getAttribute(userNameInputSelector,"value");
        return valueUserName;
    }

    public String getValueEmail (Page page){
        String valueEmail = page.getAttribute(emailInputSelector,"value");
        return valueEmail;
    }
    public String getValuePassword (Page page){
        String valuePassword = page.getAttribute(passwordInputSelector,"value");
        return valuePassword;
    }
    public String getValueBonusCode (Page page){
        String valueBonusCode = page.getAttribute(bonusCodeInputSelector,"value");
        return valueBonusCode;
    }

}
