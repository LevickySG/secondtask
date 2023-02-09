package Hooks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebHooks {
    @BeforeClass
    public static void OpenJira(){ //
        open("https://edujira.ifellow.ru/");
    }
    @Step
    public static void LogInJira(String User, String Pass){
        SelenideElement LogWindow = $(By.xpath("//input[@name=\"os_username\"]"));
        LogWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(User);
        SelenideElement PassWindow = $(By.xpath("//input[@name=\"os_password\"]"));
        PassWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(Pass);
        $(By.xpath("//input[@value=\"Войти\"]")).click();
    }
    @Step
    public static void ChooseTopMenuButton(String MenuButton){
        $(By.xpath("//a[contains(text(),\"" + MenuButton +"\")]")).click();
    }
    @Step
    public static void chooseProject(String ProjName){
        ChooseTopMenuButton("Проекты");
        $(By.xpath("//a[contains(text(),\"Просмотр всех проектов\")]")).click();
        $(By.xpath("//a[contains(text(),\"" + ProjName + "\")]")).click();
    }
    @Step
    public static String CheckTasks(String ProjName){
        chooseProject(ProjName);
        $(By.xpath("//span[contains(text(),\"Задачи\")]//parent::a")).click();
        return $(By.xpath("//span[contains(text(),\"1 из\")]")).getText().substring(5);
    }
}
