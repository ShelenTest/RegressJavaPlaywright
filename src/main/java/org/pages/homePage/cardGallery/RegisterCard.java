package org.pages.homePage.cardGallery;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
public class RegisterCard{
    private String createAccountButtonSelector = "//div[@class='card-front-body']/form/div/div/button";
    private String userNameInputSelector = "//div[@class='card-front-body']/form/div/div/div/input[@name='nickName']";
    private String emailInputSelector = "//div[@class='card-front-body']/form/div/div/div/input[@name='email']";
    private String passwordInputSelector = "//div[@class='card-front-body']/form/div/div/div/input[@name='password']";
    private String bonusCodeInputSelector = "//div[@class='card-front-body']/form/div/div/div/input[@name='bonusCode']";

    public void clickCreateAccount (Page page){page.locator(createAccountButtonSelector).click();}
    public void fillUserNameInput (Page page, String value){
        page.fill(userNameInputSelector,value);}
    public void fillEmailInput (Page page, String value){
        page.fill(emailInputSelector,value);}

    public void fillPasswordInput (Page page, String value){
        page.fill(passwordInputSelector,value);}
    public void fillBonusCodeInput (Page page, String value){
        page.fill(bonusCodeInputSelector,value);}
}
