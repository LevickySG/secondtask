package JiraElements;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Projects {
    public static SelenideElement ProjectsButton = $x("//a[contains(text(),'Проекты')]").as("Проекты");
    public static SelenideElement AllProj = $x("//a[contains(text(),'Просмотр всех проектов')]")
            .as("Просмотр всех проект");
    public static SelenideElement ChosenProject (String ProjName){
        return $x("//a[contains(text(),'" + ProjName + "')]").as(ProjName);
    }

    public static SelenideElement leftButtonTasks = $x("//span[contains(text(),'Задачи')]//parent::a");

}
