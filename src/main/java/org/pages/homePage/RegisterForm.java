package org.pages.homePage;

import com.microsoft.playwright.Page;

public class RegisterForm {
    private String getBonusButtonSelector = "//div[@class='middle']/form/div/div/button";
    private String userNameInputSelector = "//div[@class='middle']/form/div/div/div/input[@name='nickName']";
    private String emailInputSelector = "//div[@class='middle']/form/div/div/div/input[@name='email']";
    private String passwordInputSelector = "//div[@class='middle']/form/div/div/div/input[@name='password']";
    private String bonusCodeInputSelector = "//div[@class='middle']/form/div/div/div/input[@name='bonusCode']";

    public void clickGetBonusButton(Page page){
        page.click(getBonusButtonSelector);
    }
    public void fillUserNameInput (Page page, String value){
        page.fill(userNameInputSelector,value);}
    public void fillEmailInput (Page page, String value){
        page.fill(emailInputSelector,value);}

    public void fillPasswordInput (Page page, String value){
        page.fill(passwordInputSelector,value);}
    public void fillBonusCodeInput (Page page, String value){
        page.fill(bonusCodeInputSelector,value);}
}