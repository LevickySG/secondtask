package APISteps;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RickAPI {
    public static String charID;
    public static String LastEpisodeId;
    public static String LastCharacterId;
    public static String MortyLoc;
    public static String MortySpec;
    public static String CharLoc;
    public static String CharSpec;
    @Step("получение данных о первом персонаже")
    public static void getMorty() {
        Response gettingChar = given().filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + charID)
                .then()
                .extract()
                .response();
        String charName = (new JSONObject(gettingChar.getBody().asString()).get("name").toString());
        System.out.println("Character name:" + charName);
        int episode = (new JSONObject(gettingChar.getBody().asString()).getJSONArray("episode").length() - 1);
        LastEpisodeId = new JSONObject(gettingChar.getBody().asString())
                .getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", "");
        System.out.println("Last seen episode:" + LastEpisodeId);
        MortySpec = new JSONObject(gettingChar.getBody().asString()).get("species").toString();
        System.out.println(charName + " species:" + MortySpec);
        MortyLoc = new JSONObject(gettingChar.getBody().asString()).getJSONObject("location").get("name").toString();
        System.out.println(charName + " location:" + MortyLoc);

    }
    @Step("айди последнего персонажа в последнем эпизоде")
    public static void getLastID() {
        Response getCharFromEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/episode/" + LastEpisodeId)
                .then()
                .extract()
                .response();
        int lastcharId = (new JSONObject(getCharFromEpisode.getBody().asString()).getJSONArray("characters").length() - 1);
        LastCharacterId = new JSONObject(getCharFromEpisode.getBody().asString())
                .getJSONArray("characters").get(lastcharId).toString().replaceAll("[^0-9]", "");
        System.out.println("Last episode last character:");
    }
    @Step("получение информации о последнем персонаже")
    public static void getCharacter() {
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + LastCharacterId)
                .then()
                .extract()
                .response();
        String charName = (new JSONObject(gettingChar.getBody().asString()).get("name").toString());
        System.out.println("Character name:" + charName);
        CharSpec = new JSONObject(gettingChar.getBody().asString()).get("species").toString();
        System.out.println(charName + " species:" + CharSpec);
        CharLoc = new JSONObject(gettingChar.getBody().asString()).getJSONObject("location").get("name").toString();
        System.out.println(charName + " location:" + CharLoc);
    }
    @Step("сравнение данных о персонажах")
    public static void AssertEq() {
        Assertions.assertAll(
                () -> assertEquals("Another Locations",MortyLoc,CharLoc),
                () -> assertEquals("Another Species",MortySpec, CharSpec)
        );
    }
}
