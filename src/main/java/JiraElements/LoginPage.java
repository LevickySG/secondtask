package JiraElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static SelenideElement LogWindow = $x("//input[@name='os_username']").as("строка логина");
    public static SelenideElement PassWindow = $x("//input[@name='os_password']").as("строка пароля");
    public static SelenideElement LoginButton = $x("//input[@value='Войти']");
}
