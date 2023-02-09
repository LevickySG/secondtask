import Hooks.WebHooks;
import javafx.concurrent.Task;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class RunTest extends WebHooks{
    @Test
    public void test1() {//проверка количества задач, выведение статуса задачи
        String TaskName = "TestSelenium";
        LogInJira("slevicky","Qwerty123");
        System.out.println(CheckTasks("Test"));
        System.out.println("Статус задачи " + TaskName + ":" + TaskStatus(TaskName));
        System.out.println("Версия задачи " + TaskName + ":" + TaskVersion(TaskName));
    }

    @Test
    public void test2(){//открытие и закрытие бага
        LogInJira("slevicky","Qwerty123");
        TaskCreate("DefaultTask","DefaultTaskDescription","DefaultTaskEnvironment","Version 2.0");
        TaskClose("DefaultTask");
    }
}
