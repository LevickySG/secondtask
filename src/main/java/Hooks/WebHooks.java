package Hooks;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public class WebHooks {
    @Before
    public static void OpenJira(){ //
        Selenide.open("https://edujira.ifellow.ru/");
    }//открытие сайта перед стартом программы
    @After
    public static void CloseJira(){Selenide.closeWebDriver();}
}
