package Steps;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

import JiraElements.Projects;
public class ChooseProject {
    @Step("открытие страницы с проектом")
    public static void chooseProject(String ProjName){
        Projects.ProjectsButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        Projects.AllProj.shouldBe(visible, Duration.ofSeconds(5)).click();
        Projects.ChosenProject(ProjName).shouldBe(visible,Duration.ofSeconds(5)).click();
    }
}
