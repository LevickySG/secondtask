package Tests;

import Hooks.WebHooks;
import org.junit.Test;

import static Steps.CreateTask.TaskCreate;

import Steps.*;

public class RunTest extends WebHooks{
    @Test
    public void test1() {//проверка количества задач, выведение статуса задачи
        String TaskName = "TestSelenium";
        Authorization.LogInJira("slevicky","Qwerty123");
        System.out.println(Steps.NumberOfTaskCheck.CheckTasks("Test"));
        System.out.println("Статус задачи " + TaskName + ":" + TaskStatus.Status(TaskName));
        System.out.println("Версия задачи " + TaskName + ":" + TaskStatus.TaskVersion(TaskName));
    }

    @Test
    public void test2(){//открытие и закрытие бага
        Authorization.LogInJira("slevicky","Qwerty123");
        TaskCreate("DefaultTask","DefaultTaskDescription","DefaultTaskEnvironment","Version 2.0");
        TaskClose.Close("DefaultTask");
    }
}
