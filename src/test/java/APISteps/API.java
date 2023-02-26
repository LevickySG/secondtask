package APISteps;


import static io.restassured.RestAssured.given;

public class API {

    public static void authen(){
        given().auth()
                .preemptive()
                .basic("slevicky", "Qwerty123")
                .when()
                .get("https://edujira.ifellow.ru/login.jsp")
                .then()
                .assertThat()
                .statusCode(200);
    }
}



