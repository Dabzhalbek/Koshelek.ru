package org.koshelek.koshelek;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPageTest {
    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        driver.get("https://koshelek.ru/authorization/signup");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testUsernameFieldWithTooShortLength() {
        registrationPage.usernameField().sendKeys("abcde"); // 5 символов, меньше минимального
        registrationPage.submitButton().click();
        assertTrue(registrationPage.usernameAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmUserName,registrationPage.usernameAlarmField().getText());
    }

    @Test
    public void testUsernameFieldWithTooLongLength() {
        registrationPage.usernameField().sendKeys("abcdefghijklmnopqrstuvwxyz123456o\\o"); // 33 символа, превышает максимальное
        assertTrue(registrationPage.usernameAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarUserNameTooLong, registrationPage.usernameAlarmField().getText());
        registrationPage.submitButton().click();
        assertTrue(registrationPage.usernameAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmUserName, registrationPage.usernameAlarmField().getText());
    }

    @Test
    public void testUsernameFieldWithSpecialCharacters() {
        registrationPage.usernameField().sendKeys("!@#$%^&*()"); // Только специальные символы
        registrationPage.submitButton().click();
        assertTrue(registrationPage.usernameAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmUserName,registrationPage.usernameAlarmField().getText());
    }

    @Test
    public void testEmailFieldWithInvalidFormatMissingAt() {
        registrationPage.emailField().sendKeys("userexample.com"); // Отсутствует символ '@'
        registrationPage.submitButton().click();
        assertTrue(registrationPage.emailAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmMail,registrationPage.emailAlarmField().getText());
    }

    @Test
    public void testEmailFieldWithInvalidFormatMissingDomain() {
        registrationPage.emailField().sendKeys("user@.com"); // Отсутствует домен
        registrationPage.submitButton().click();
        assertTrue(registrationPage.emailAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmMail,registrationPage.emailAlarmField().getText());
    }

    @Test
    public void testEmailFieldWithTooManyCharactersBeforeAt(){
        registrationPage.emailField().sendKeys("a".repeat(256)); // 256 символов
        registrationPage.submitButton().click();
        assertTrue(registrationPage.emailAlarmField().isDisplayed());
        assertEquals( ExpectedErrors.alarmMail,registrationPage.emailAlarmField().getText());
    }

    @Test
    public void testEmailFieldWithInvalidCharacters() {
        registrationPage.emailField().sendKeys("user@exa$mple.com"); // Неверный символ '$'
        registrationPage.submitButton().click();
        assertTrue(registrationPage.emailAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmMail,registrationPage.emailAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithTooShortLength() throws InterruptedException {
        registrationPage.passwordField().sendKeys("Short12"); // 7 символов, меньше минимального
        registrationPage.submitButton().click();
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmPasswordTooShort, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithTooLongLength() {
        registrationPage.passwordField().sendKeys("a".repeat(65) + "1A"); // 65 символов, превышает максимальное
        registrationPage.submitButton().click();
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmPassword, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithoutUppercase() {
        registrationPage.passwordField().sendKeys("lowercase123"); // Нет заглавной буквы
        registrationPage.submitButton().click();
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmPassword, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithoutDigits() {
        registrationPage.passwordField().sendKeys("UppercaseLetters"); // Нет цифр
        registrationPage.submitButton().click();
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmPassword, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithSpecialCharactersOnly() {
        registrationPage.passwordField().sendKeys("!@#$%^&*()"); // Только специальные символы
        registrationPage.submitButton().click();
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmPassword, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithSpaces() throws InterruptedException {
        registrationPage.passwordField().sendKeys("Password 1"); // Содержит пробел
        registrationPage.submitButton().click();
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmPassword, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testReferralCodeFieldWithTooShortLength() {
        registrationPage.referallCodeField().sendKeys("AB"); // 2 символа, меньше минимального (например, 3)
        assertTrue(registrationPage.referallCodeAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmRefCode, registrationPage.referallCodeAlarmField().getText());
    }

    @Test
    public void testReferralCodeFieldWithTooLongLength() {
        registrationPage.referallCodeField().sendKeys("A".repeat(256)); // 21 символ, превышает максимальное (например, 20)
        assertTrue(registrationPage.referallCodeAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmRefCode, registrationPage.referallCodeAlarmField().getText());
    }

    @Test
    public void testReferralCodeFieldWithInvalidCharacters()  {
        registrationPage.referallCodeField().sendKeys("Invalid#Code!"); // Недопустимые символы
        assertTrue(registrationPage.referallCodeAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.alarmRefCode, registrationPage.referallCodeAlarmField().getText());
    }
    @Test
    public void testUsernameFieldWithEmptyData() {
        // Оставить поле имени пользователя пустым и нажать кнопку отправки
        registrationPage.usernameField().sendKeys("");
        registrationPage.submitButton().click();

        // Проверить, что сообщение об ошибке отображается и соответствует ожиданиям
        assertTrue(registrationPage.usernameAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.emptyField, registrationPage.usernameAlarmField().getText());
    }

    @Test
    public void testPasswordFieldWithEmptyData() {
        // Оставить поле пароля пустым и нажать кнопку отправки
        registrationPage.passwordField().sendKeys("");
        registrationPage.submitButton().click();

        // Проверить, что сообщение об ошибке отображается и соответствует ожиданиям
        assertTrue(registrationPage.passwordAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.emptyField, registrationPage.passwordAlarmField().getText());
    }

    @Test
    public void testEmailFieldWithEmptyData() {
        // Оставить поле email пустым и нажать кнопку отправки
        registrationPage.emailField().sendKeys("");
        registrationPage.submitButton().click();

        // Проверить, что сообщение об ошибке отображается и соответствует ожиданиям
        assertTrue(registrationPage.emailAlarmField().isDisplayed());
        assertEquals(ExpectedErrors.emptyField, registrationPage.emailAlarmField().getText());
    }
}
