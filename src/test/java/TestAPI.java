import APISteps.LogAPI;
import APISteps.RickAPI;
import hooks.ApiHooks;
import io.qameta.allure.Epic;

import org.junit.Test;
import APISteps.ReqAPI;

import java.io.IOException;

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
