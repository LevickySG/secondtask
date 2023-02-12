package Hooks;

import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.*;

public class WebHooks {
    @BeforeClass
    public static void OpenJira(){ //
        open("https://edujira.ifellow.ru/");
    }//открытие сайта перед стартом программы


}
