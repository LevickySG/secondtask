import Hooks.WebHooks;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class RunTest extends WebHooks{
    @Test
    public void test1() {
        LogInJira("slevicky","Qwerty123");
        System.out.println(CheckTasks("Test"));
    }

}
