package Hooks;

import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class WebHooks {
    @BeforeClass
    public static void chromesopen(){ //открывает Сайт СГУ, Страницу кафедры
        open("https://www.sgu.ru/");
        $(By.linkText("Институт физики")).click();
        $(By.linkText("Структура")).click();
        $(By.linkText("Кафедра радиотехники и электродинамики")).click();
    }
}
