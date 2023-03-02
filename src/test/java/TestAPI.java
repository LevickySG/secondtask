import APISteps.RickAPI;
import org.junit.Test;


public class TestAPI {
    @Test
    public void testRickAPI(){
        RickAPI.charID = "2";
        RickAPI.getMorty();
        RickAPI.getLastID();
        RickAPI.getCharacter();
        RickAPI.AssertEq();
    }
}
