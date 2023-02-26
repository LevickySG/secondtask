import APISteps.API;
import org.junit.Test;

import static APISteps.API.*;

public class TestAPI {
    @Test
    public void test1(){
        charID = "2";
        API.getCharacter("2");
        API.getLastEpisode("2");
        API.getCharFromEpisode(LastEpisodeId);
        API.getCharSpecies(LastCharacterId);
        API.getCharLocation(LastCharacterId);
        API.dataEqual("2",LastCharacterId);
    }
}
