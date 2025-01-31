package api.api.jsonplaceholder;

import api.api.common.EndPoints;
import auth.TokenGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.RandomEmailGenerator;
import utils.RandomUserName_Password;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class my_next_app_api {







    public static Response getStudents() {

        return RestAssured
                .given()
                .get(EndPoints.MY_NEXT_APP_GET);

    }

    public static Response getSpecificStudent(String id) {

        return RestAssured
                .given()
                .get(EndPoints.MY_NEXT_APP_GET_SPECIFIC_STUDENT+id);

    }

    public static Response POSTStudent(String name,String email) {

        return RestAssured
                .given()

                .body("{ \"id\": " + "1" +
                        ", \"name\": \"" + name + "\"" +
                        ", \"email\": \"" + email + "\"" +
                        ", \"active\": " + "false" +
                        ", \"createdAt\": \"" + "2025-01-09T16:13:22.538Z" + "\" }")

                .post(EndPoints.MY_NEXT_APP_POST_STUDENTS);

    }

    public static Response deleteSpecificStudent(String id) {

        return RestAssured
                .given()
                .delete(EndPoints.MY_NEXT_APP_GET_SPECIFIC_STUDENT+id);

    }





}
