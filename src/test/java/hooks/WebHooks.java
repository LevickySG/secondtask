package hooks;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {
    @BeforeEach
    public void allureStarter(){
        String listenerName = "AllureSelenide";
        if(!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
        new AllureSelenide().screenshots(true).savePageSource(false));
    }
    @AfterEach
    public void driverClose(){
        WebDriverRunner.closeWebDriver();
    }
}
