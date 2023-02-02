import Hooks.WebHooks;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class RunTest extends WebHooks{
    String names;// глобальная переменная должности
    @Test
    public void test1() {//Проверка занимаемой должности по имени сотрудника, корректный тест
        $(By.linkText("Давидович Михаил Владимирович")).click();
        names = $(By.xpath("//*[@id=\"block-system-main\"]" +
                "/article/div[1]/div/div[1]/div[1]/div/div/div")).getText();
        Assert.assertEquals("Профессор",names);
    }
    @Test
    public void test2(){//Проверка занимаемой должности по имени сотрудника, некорректный тест
        $(By.linkText("Левицкий Семён Геннадьевич")).click();
        names = $(By.xpath("//*[@id=\"block-system-main\"]" +
                "/article/div[1]/div/div[1]/div[1]/div/div/div")).getText();
        Assert.assertEquals("Профессор",names);
    }
    @After
    public void exittest(){//в конце теста выводит название занимаемой должности
        System.out.println("Занимаемая должность:"+names);
    }
}
