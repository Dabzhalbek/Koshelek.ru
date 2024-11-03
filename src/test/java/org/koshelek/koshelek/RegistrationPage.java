package org.koshelek.koshelek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    @FindBy(xpath = "//*[@id=\"input-3214\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement mail;

    @FindBy(xpath = "//*[@id=\"new-password\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=input-3254]")
    public WebElement referalCode;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
