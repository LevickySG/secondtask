package Steps;

import JiraElements.LoginPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class Authorization {
    @Step("Логин в системе")
    public static void LogInJira(String User, String Pass){
        LoginPage.LogWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(User);
        LoginPage.PassWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(Pass);
        LoginPage.LoginButton.shouldBe(visible, Duration.ofSeconds(5)).click();
    }
}
