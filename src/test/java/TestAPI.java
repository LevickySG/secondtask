import APISteps.LogAPI;
import APISteps.RickAPI;
import org.junit.Test;
import APISteps.ReqAPI;

import java.io.IOException;

public class TestAPI {
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
