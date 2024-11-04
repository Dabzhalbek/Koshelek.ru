package org.koshelek.koshelek;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Замените на используемый вами драйвер

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage() {
        // Инициализация драйвера, например, Chrome
        this.driver = new ChromeDriver();
        driver.get("https://koshelek.ru/authorization/signup"); // Замените на URL вашей страницы
    }

    public void getShadowRoot() throws InterruptedException {
        // Используйте правильный селектор
        Thread.sleep(30000);
        WebElement shadowHost = driver.findElement(By.cssSelector("#attach_modal > section > div > div:nth-child(2) > div"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        String text = shadowRoot.findElement(By.cssSelector("div.remoteApplication > div > div > div > div.css-grid.k-text-default > div:nth-child(2) > form > div > div:nth-child(1) > div > div > div.v-input__slot > div.v-text-field__slot > label")).getText();
        System.out.println(text); // Вывод текста
    }

    public static void main(String[] args) throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.getShadowRoot(); // Вызов метода
    }
}
