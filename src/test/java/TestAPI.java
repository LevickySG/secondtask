import APISteps.LogAPI;
import APISteps.RickAPI;
import hooks.ApiHooks;
import io.qameta.allure.Epic;
import APISteps.ReqAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
@DisplayName("Api tests")
public class TestAPI extends ApiHooks {
    @Epic(value="RickAPI")
    @Test
    public void testRickAPI(){
        RickAPI.charID = "2";
        RickAPI.getMorty();
        RickAPI.getLastID();
        RickAPI.getCharacter();
        RickAPI.AssertEq();
    }
    @Epic(value="reqAPI")
    @Test
    public void testReqAPI() throws IOException {
        ReqAPI.sendBody();
    }

    @Epic(value="JiraAPI")
    @Test
    public void JiraLog(){
        LogAPI.authen();
    }
}
