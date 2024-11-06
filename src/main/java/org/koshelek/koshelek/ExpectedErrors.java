package org.koshelek.koshelek;

public class ExpectedErrors {
    public static final String alarmUserName = "Допустимые символы (от 6 до 32): a-z, 0-9, _. Имя должно начинаться с буквы";
    public static final String alarUserNameTooLong = "Превышен лимит символов: 32 максимум";
    public static final String alarmMail = "Формат e-mail: username@test.ru";
    public static final String alarmPassword = "Пароль должен содержать от 8 до 64 символов, включая заглавные буквы и цифры";
    public static final String alarmPasswordTooShort = "Пароль должен содержать минимум 8 символов";
    public static final String alarmPasswordTooLong = "Превышен лимит символов: 64 максимум";
    public static final String alarmRefCode = "Неверный формат ссылки";
    public static final String emptyField = "Поле не заполнено";
}
