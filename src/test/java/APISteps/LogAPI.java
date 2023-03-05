package APISteps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static io.restassured.RestAssured.given;

public class LogAPI {
    @Step("аутентификация")
    public static void authen(){
        given().filter(new AllureRestAssured()).filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter()).auth()
                .preemptive()
                .basic("slevicky", "Qwerty123").filter(new AllureRestAssured())
                .when()
                .get("https://edujira.ifellow.ru/login.jsp")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}
