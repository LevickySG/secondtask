package APISteps;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ReqAPI {
        @Step("редактировние джейсон файла в API")
        public static void sendBody() throws IOException {
            JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/JSON/name.json"))));
            body.put("Rhymes", new String[]{"Topato", "Pomato"});
            body.put("name","Tomato");
            body.put("job","Katsup Factory");
            Response postJSON = given()
                    .filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                    .filter(new ResponseLoggingFilter())
                    .header("Content-Type","application/json")
                    .baseUri("https://reqres.in/api")
                    .body(body.toString())
                    .when()
                    .post("/users")
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();
            System.out.println(postJSON.getBody().asString());
        }
}
