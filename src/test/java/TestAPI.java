import APISteps.LogAPI;
import APISteps.RickAPI;
import com.codeborne.selenide.logevents.SelenideLogger;
import hooks.ApiHooks;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.Test;
import APISteps.ReqAPI;

import java.io.IOException;

public class TestAPI extends ApiHooks {
    @BeforeClass
    public static void listenerStart(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(true).screenshots(true));
    }
    @Test
    public void testRickAPI(){
        RickAPI.charID = "2";
        RickAPI.getMorty();
        RickAPI.getLastID();
        RickAPI.getCharacter();
        RickAPI.AssertEq();
    }
    @Test
    public void testReqAPI() throws IOException {
        ReqAPI.sendBody();
    }

    @Test
    public void JiraLog(){
        LogAPI.authen();
    }
}
