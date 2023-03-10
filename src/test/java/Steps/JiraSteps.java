package Steps;

import JiraElements.Creation;
import JiraElements.LoginPage;
import JiraElements.Projects;
import JiraElements.Tasks;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static JiraElements.ToolBar.ChooseTopMenuButton;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

@Tag("TEST")
public class JiraSteps {

    public static String TaskName;
    public static String login;
    public static String pass;
    public static String TaskDescription;
    public static String TaskEnv;
    public static String TaskVer;
    public static String ProjName = "Test";
    @Дано("логин {string}, пароль {string}, имя задачи {string}")
    public static void логи_нпароль_имя_задачи (String log, String pas, String tname){
        TaskName = tname;
        login = log;
        pass = pas;
    }
    @Дано("логин {string}, пароль {string}, имя задачи {string}, описание {string}, окружение {string}, версия {string}")
    public static void логин_пароль_имя_задачи_описание_окружение_версия
            (String log, String pas, String tname, String desc, String env, String ver){
        TaskName = tname;
        login = log;
        pass = pas;
        TaskDescription = desc;
        TaskEnv = env;
        TaskVer = ver;
    }
    @Тогда("логин в системе")
    public void логинВСистеме() {
        Selenide.open("https://edujira.ifellow.ru/");
        LoginPage.LogWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(login);
        LoginPage.PassWindow.shouldBe(visible, Duration.ofSeconds(5)).setValue(pass);
        LoginPage.LoginButton.shouldBe(visible, Duration.ofSeconds(5)).click();
    }
    @Затем("вывод статуса и версии")
    public void выводСтатусаИВерсии() {
        System.out.println(TaskVersion());
        System.out.println(Status());
        Selenide.closeWebDriver();
    }
    @Затем("создание задачи и закрытие задачи")
    public void созданиеЗадачиИЗакрытиеЗадачи() throws IOException {
        TaskCreate();
        Close();
        Selenide.closeWebDriver();
    }
    @Step("открытие страницы с проектом")
    public static void chooseProject(){
        Projects.ProjectsButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        Projects.AllProj.shouldBe(visible, Duration.ofSeconds(5)).click();
        Projects.ChosenProject(ProjName).shouldBe(visible,Duration.ofSeconds(5)).click();
    }
    @Attachment
    public static byte[] StepScreenshot (String ImgName) throws IOException{
        String AfterStep = screenshot(ImgName);
        return Files.readAllBytes(Paths.get(AfterStep.substring(6)));
    }

    @Step("Создание задачи")
    public static void TaskCreate () throws IOException {
        Configuration.reportsFolder = "target/allure-results";
        Creation.CreateButton.shouldBe(visible,Duration.ofSeconds(5)).click();
        StepScreenshot("Нажатие_кнопки");
        Creation.TaskThemeField.setValue(TaskName);
        StepScreenshot("ввод_имени_задачи");
        Creation.Description.shouldBe(visible, Duration.ofSeconds(5)).setValue(TaskDescription);
        StepScreenshot("ввод_описания");
        Creation.Environment.shouldBe(visible,Duration.ofSeconds(5)).setValue(TaskEnv);
        StepScreenshot("ввод_окружения");
        Creation.Versions(TaskVer).shouldBe(visible,Duration.ofSeconds(5)).click();
        StepScreenshot("ввод_Версии");
        Creation.CreateConfirm.shouldBe(visible,Duration.ofSeconds(5)).click();
    }
    @Step("проверка количества заданий")
    public static String CheckTasks(){
        chooseProject();
        Projects.leftButtonTasks.shouldBe(visible, Duration.ofSeconds(5)).click();
        return $x("//span[contains(text(),\"1 из\")]").getText().substring(5);
    }
    @Step("Закрытие задачи")
    public static void Close(){//закрытие задачи
        ChooseTasks();
        Tasks.TaskStatusButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.SdelatButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.BusyButt.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.DoneButt.shouldBe(visible,Duration.ofSeconds(20)).click();
        sleep(1000);
        //посленяя стрчока выглядит как костыль, но без неё программе не хватает времени, чтобы измениня ушли в Жиру
    }
    @Step("переход на страницу задачи")
    public static void ChooseTasks(){
        ChooseTopMenuButton("Задачи").shouldBe(visible, Duration.ofSeconds(5)).click();
        Tasks.TaskSearch.shouldBe(visible, Duration.ofSeconds(5)).click();
        SelenideElement TextField = $x("//input[@placeholder=\"Содержит текст\"]");
        TextField.setValue(TaskName).pressEnter();
    }
    @Step
    public static String Status (){//возвращает статус задачи
        ChooseTasks();
        Configuration.reportsFolder = "target/allure-results";
        return (($(By.xpath("//span[@id='status-val']//child::span")).getText()));
    }
    @Step
    public static String TaskVersion (){//возвращает версию задачи
        ChooseTasks();
        Configuration.reportsFolder = "target/allure-results";
        return (($(By.xpath("//strong[@title='Исправить в версиях']" +
                "//following-sibling::span//child::span//child::a")).getText()));
    }

}