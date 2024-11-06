package org.koshelek.koshelek;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Метод для поиска элемента поля username
    public WebElement usernameAlarmField() {
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector
                        ("div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div:nth-child(1) > div > div > div.v-text-field__details > div > div > div > div > div > span"))));
    }

    public WebElement emailAlarmField() {
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector
                        ("div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div:nth-child(2) > div > div > div.v-text-field__details > div > div > div > div > div > span"))));
    }

    public WebElement passwordAlarmField() {
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector
                        ("div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div:nth-child(3) > div > div > div > div > div.v-text-field__details > div > div > div > div > div > span"))));
    }

    public WebElement referallCodeAlarmField(){
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector(
                        "div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div:nth-child(4) > div > div > div.v-text-field__details > div > div > div > div > div > span"))));
    }

    public WebElement usernameField() {
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector
                        ("input[hide-spin-buttons=\"true\"][colorscheme=\"dark\"][specialtoken=\"k-text-field-primary\"]"))));
    }

    public WebElement emailField() {
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector
                        ("input[entrybyemailorphone=\"AUTH.emailOrPhone\"][id=\"username\"][type=\"email\"]"))));
    }

    public WebElement passwordField() {
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector
                        ("input[name=\"new-password\"][id=\"new-password\"][type=\"password\"]"))));
    }

    public WebElement referallCodeField(){
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector(
                        "div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div:nth-child(4) > div > div > div.v-input__slot > div.v-text-field__slot > input[type=text]"))));
    }

    public WebElement submitButton(){
        return wait.until(ExpectedConditions.visibilityOf(
                getShadowRoot().findElement(By.cssSelector(
                        "div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div.k-btn-long-button > button"))));
    }

    // Метод для получения shadow root
    public SearchContext getShadowRoot() {
        WebElement shadowHost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                cssSelector("#attach_modal > section > div > div:nth-child(2) > div")));
        return shadowHost.getShadowRoot();
    }
}
