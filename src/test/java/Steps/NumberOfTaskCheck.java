package Steps;

import JiraElements.Projects;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
public class NumberOfTaskCheck {
    @Step("проверка количества заданий")
    public static String CheckTasks(String ProjName){
        ChooseProject.chooseProject(ProjName);
        Projects.leftButtonTasks.shouldBe(visible, Duration.ofSeconds(5)).click();
        return $x("//span[contains(text(),\"1 из\")]").getText().substring(5);
    }
}
