import APISteps.RickAPI;
import org.junit.Test;
import APISteps.ReqAPI;

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
    public void testReqAPI(){
        ReqAPI.smh();
    }
}
