package APISteps;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class API {
    public static String charID;
    public static String LastEpisodeId;
    public static String LastCharacterId;
    public static void getCharacter(String charId){
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + charId)
                .then()
                .extract()
                .response();
        String charName = (new JSONObject(gettingChar.getBody().asString()).get("name").toString());
        System.out.println("Character name:" + charName);
    }
    public static void getLastEpisode(String charId) {
        Response gettingLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + charId)
                .then()
                .extract()
                .response();
        int episode = (new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        LastEpisodeId = new JSONObject(gettingLastEpisode.getBody().asString())
                .getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
        System.out.println("Last seen episode:" +LastEpisodeId);
    }

        public static void getCharFromEpisode(String episodeId){
            Response getCharFromEpisode = given()
                    .baseUri("https://rickandmortyapi.com/api")
                    .when()
                    .get("/episode/" + episodeId)
                    .then()
                    .extract()
                    .response();
            int lastcharId = (new JSONObject(getCharFromEpisode.getBody().asString()).getJSONArray("characters").length()-1);
            LastCharacterId = new JSONObject(getCharFromEpisode.getBody().asString())
                    .getJSONArray("characters").get(lastcharId).toString().replaceAll("[^0-9]", "");
            System.out.println("Last episode last character:");
            getCharacter(LastCharacterId);
        }
        public static void getCharSpecies(String characterId){
            Response getCharSpecies = given()
                    .baseUri("https://rickandmortyapi.com/api")
                    .when()
                    .get("/character/" + characterId)
                    .then()
                    .extract()
                    .response();
            String CharSpecies = new JSONObject(getCharSpecies.getBody().asString()).get("species").toString();
            System.out.println(CharSpecies);
        }
    public static void getCharLocation(String characterId){
        Response getCharLocation = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + characterId)
                .then()
                .extract()
                .response();
        String CharLoc = new JSONObject(getCharLocation.getBody().asString()).getJSONObject("location").get("name").toString();
        System.out.println(CharLoc);
    }
    public static void dataEqual (String char1id, String char2id){
        Response data1 = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + char1id)
                .then()
                .extract()
                .response();
        String Char1Loc = new JSONObject(data1.getBody().asString()).getJSONObject("location").get("name").toString();
        String Char1Species = new JSONObject(data1.getBody().asString()).get("species").toString();
        Response data2 = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + char2id)
                .then()
                .extract()
                .response();
        String Char2Loc = new JSONObject(data2.getBody().asString()).getJSONObject("location").get("name").toString();
        String Char2Species = new JSONObject(data2.getBody().asString()).get("species").toString();
        if (Char1Loc.equals(Char2Loc)){
            System.out.println("this character in same location");
        }
        else{
            System.out.println("this character in another location");
        }
        if (Char1Species.equals(Char2Species)){
            System.out.println("this character is the same species");
        }
        else{
            System.out.println("this character is another species");
        }
        }
    }
