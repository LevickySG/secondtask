package Steps;

import JiraElements.Tasks;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static JiraElements.ToolBar.ChooseTopMenuButton;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TaskStatus {
    @Step("переход на страницу задачи")
    public static void ChooseTasks(String TaskName){
        ChooseTopMenuButton("Задачи").shouldBe(visible, Duration.ofSeconds(5)).click();
        Tasks.TaskSearch.shouldBe(visible, Duration.ofSeconds(5)).click();
        SelenideElement TextField = $x("//input[@placeholder=\"Содержит текст\"]");
        TextField.setValue(TaskName).pressEnter();
    }

    public static String Status (String TaskName){//возвращает статус задачи
        ChooseTasks(TaskName);
        return (($(By.xpath("//span[@id='status-val']//child::span")).getText()));
    }

    public static String TaskVersion (String TaskName){//возвращает версию задачи
        ChooseTasks(TaskName);
        return (($(By.xpath("//strong[@title='Исправить в версиях']" +
                "//following-sibling::span//child::span//child::a")).getText()));
    }

}
