package Steps;

import JiraElements.Creation;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class CreateTask {
    @Step("Создание задачи")
    public static void TaskCreate (String TaskTheme, String TaskDescription, String TaskEnv, String TaskVer){
        Creation.CreateButton.shouldBe(visible,Duration.ofSeconds(5)).click();
        Creation.TaskThemeField.setValue(TaskTheme);
        Creation.Description.shouldBe(visible, Duration.ofSeconds(5)).setValue(TaskDescription);
        Creation.Environment.shouldBe(visible,Duration.ofSeconds(5)).setValue(TaskEnv);
        Creation.Versions(TaskVer).shouldBe(visible,Duration.ofSeconds(5)).click();
        Creation.CreateConfirm.shouldBe(visible,Duration.ofSeconds(5)).click();
    }
}
