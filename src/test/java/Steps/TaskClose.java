package Steps;

import JiraElements.Tasks;
import io.qameta.allure.Step;

import java.time.Duration;

import static Steps.TaskStatus.ChooseTasks;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class TaskClose {
    @Step("Закрытие задачи")
    public static void Close(String TaskName){//закрытие задачи
        ChooseTasks(TaskName);
        Tasks.TaskStatusButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.SdelatButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.BusyButt.shouldBe(visible, Duration.ofSeconds(20)).click();
        Tasks.DoneButt.shouldBe(visible,Duration.ofSeconds(20)).click();
        sleep(1000);
        //посленяя стрчока выглядит как костыль, но без неё программе не хватает времени, чтобы измениня ушли в Жиру
    }
}
