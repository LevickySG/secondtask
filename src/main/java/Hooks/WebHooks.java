package Hooks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jdk.internal.cmm.SystemResourcePressureImpl;
import org.checkerframework.common.value.qual.StringVal;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import java.sql.Struct;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebHooks {
    @BeforeClass
    public static void OpenJira(){ //
        open("https://edujira.ifellow.ru/");
    }//открытие сайта перед стартом программы
    @Step("Логин в системе")
    public static void LogInJira(String User, String Pass){
        SelenideElement LogWindow = $(By.xpath("//input[@name=\"os_username\"]"));
        LogWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(User);
        SelenideElement PassWindow = $(By.xpath("//input[@name=\"os_password\"]"));
        PassWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(Pass);
        $(By.xpath("//input[@value=\"Войти\"]")).click();
    }
    @Step("выбор кнопки из верхнего тулбара")
    public static void ChooseTopMenuButton(String MenuButton){
        $(By.xpath("//a[contains(text(),\"" + MenuButton +"\")]")).click();
    }
    @Step("открытие страницы с проектом")
    public static void chooseProject(String ProjName){
        ChooseTopMenuButton("Проекты");
        $(By.xpath("//a[contains(text(),\"Просмотр всех проектов\")]")).click();
        $(By.xpath("//a[contains(text(),\"" + ProjName + "\")]")).click();
    }
    @Step("проверка количества заданий")
    public static String CheckTasks(String ProjName){
        chooseProject(ProjName);
        $(By.xpath("//span[contains(text(),\"Задачи\")]//parent::a")).click();
        return $(By.xpath("//span[contains(text(),\"1 из\")]")).getText().substring(5);
    }
    @Step("переход на страницу задачи")
    public static void ChooseTasks(String TaskName){
        ChooseTopMenuButton("Задачи");
        $(By.xpath("//a[contains(text(), \"Поиск задач\")]")).click();
        $(By.xpath("//input[@placeholder=\"Содержит текст\"]")).setValue(TaskName).pressEnter();
    }

    public static String TaskStatus (String TaskName){//возвращает статус задачи
        ChooseTasks(TaskName);
        return (($(By.xpath("//span[@id=\"status-val\"]//child::span")).getText()));
    }

    public static String TaskVersion (String TaskName){//возвращает версию задачи
        ChooseTasks(TaskName);
        return (($(By.xpath("//strong[@title=\"Исправить в версиях\"]" +
                "//following-sibling::span//child::span//child::a")).getText()));
    }
    @Step("Создание задачи")
    public static void TaskCreate (String TaskTheme, String TaskDescription, String TaskEnv, String TaskVer){
        ChooseTopMenuButton("Создать");
        $(By.xpath("//label[contains(text(),\"Тема\")]//following-sibling::input")).setValue(TaskTheme);
        $(By.xpath("//div[@id=\"description-wiki-edit\"]//child::textarea"))
                .shouldBe(visible,Duration.ofSeconds(10)).setValue(TaskDescription);
        $(By.xpath("//div[@id=\"environment-wiki-edit\"]//child::textarea"))
                .shouldBe(visible,Duration.ofSeconds(10)).setValue(TaskEnv);
        $(By.xpath("//select[@id=\"fixVersions\"]//descendant::option[contains(text(),\""
                +TaskVer+"\")]")).click();
        $(By.xpath("//input[@value=\"Создать\"]")).click();
    }
    @Step("Закрытие задачи")
    public static void TaskClose(String TaskName){//закрытие задачи
        ChooseTasks(TaskName);
        $(By.xpath("//span[contains(text(),\"Бизнес-процесс\")]//parent::a"))
                .shouldBe(visible,Duration.ofSeconds(20)).click();
        $(By.xpath("//span[contains(text(),\"Выполнено\")]"))
                .shouldBe(visible,Duration.ofSeconds(20)).click();
        $(By.xpath("//span[contains(text(),\"Выполнено\")]")).shouldBe(visible,Duration.ofSeconds(20));
        //посленяя стрчока выглядит как костыль, но без неё программе не хватает времени, чтобы измениня ушли в Жиру
    }
}
