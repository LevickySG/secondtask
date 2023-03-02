package APISteps;

import static io.restassured.RestAssured.given;

public class LogAPI {
    public static void authen(){
        given().auth()
                .preemptive()
                .basic("slevicky", "Qwerty123")
                .when()
                .get("https://edujira.ifellow.ru/login.jsp")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}
