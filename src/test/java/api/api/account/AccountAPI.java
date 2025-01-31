package api.api.account;

import api.api.common.EndPoints;
import auth.TokenGenerator;
import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.RandomUserName_Password;

import static io.restassured.RestAssured.given;

public class AccountAPI {


    public static Response createUser(String userName,String password) {
//        String userName=ConfigLoader.getProperty("supervisor.username");
//        String password=ConfigLoader.getProperty("supervisor.password");

        String body="{ \"userName\": \"" + userName + "\", \"password\": \"" + password + "\" }";

        return RestAssured
                .given()
                .contentType("application/json")
                .body(body)
                .post(EndPoints.ACCOUNT_USER_POST);
    }


    public static Response authorized() {
        String userName= ConfigLoader.getProperty("supervisor.username");
        String password=ConfigLoader.getProperty("supervisor.password");
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken()) // Add the Authorization header
                .body("{ \"userName\": \"" + userName + "\", \"password\": \"" + password + "\" }")
                .post(EndPoints.ACCOUNT_AUTHORIZED_ACCOUNT);
    }

    public static Response deleteUser(String userId) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken())
                .when()
                .delete(EndPoints.ACCOUNT_DELETE_USER+userId);
    }

    public static Response getUser(String userId) {
        return RestAssured
                .given()
//                .header("accept","application/json") //optional
                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken())
                .when()
                .get(EndPoints.ACCOUNT_GET_USER+userId);
    }



    public static Response getUserWithoutToken(String userId) {
        return RestAssured
                .given()
                .header("accept","application/json") //optional
                .pathParams("UUID",userId)
//                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken())
                .when()
                .get(EndPoints.ACCOUNT_GET_USER_Without_Token);
    }




    //*********this methods is created for AllTests Class*******************************
    public static String generateUserName( ) {
        String userName= RandomUserName_Password.generateUserName();
        return userName;
    }
    public static String generatePassword( ) {
        String pass= RandomUserName_Password.generatePass();
        return pass;
    }

    public static Response createUserRandomName(String userName,String password) {
        return RestAssured
                .given()
                . contentType("application/json")
                .body("{ \"userName\": \"" + userName + "\", \"password\": \"" + password + "\" }")
                .post(EndPoints.ACCOUNT_USER_POST);
    }

    public static Response authorizedForRandomName(String userName,String password) {
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password)) // Add the Authorization header
                .body("{ \"userName\": \"" + userName + "\", \"password\": \"" + password + "\" }")
                .post(EndPoints.ACCOUNT_AUTHORIZED_ACCOUNT);
    }

    public static Response deleteUserForRandomUser(String userName,String password,String userId) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password))
                .when()
                .delete(EndPoints.ACCOUNT_DELETE_USER+userId);
    }


    public static Response getUserForRandomUser(String userName,String password,String userId) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password)) // Add the Authorization header
                .when()
                .get(EndPoints.ACCOUNT_GET_USER+userId);
    }
    //



}
