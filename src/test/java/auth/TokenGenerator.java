package auth;

import api.api.common.EndPoints;
import config.ConfigLoader;
import config.Environment;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class TokenGenerator {

    public static String generateToken(String userName,String password){

        Environment currentEnv = Environment.getCurrentEnvironment();
        RestAssured.baseURI =currentEnv.getBaseUrl();
        Response response  =given()
                . contentType("application/json")
                .body("{ \"userName\": \"" + userName + "\", \"password\": \"" + password + "\" }")
                .post(EndPoints.ACCOUNT_GENERATE_TOKEN);
        if (response.statusCode() == 200){
            return response.jsonPath().getString("token");
        }else {
            throw new RuntimeException("Failed to generate token for user: "+userName +"Status code" +response.statusCode());
        }
    }



    public static String getSupervisiorToken(){
      String userName=  ConfigLoader.getProperty("supervisor.username");
        String password=  ConfigLoader.getProperty("supervisor.password");
       return generateToken(userName,password);
    }

    public static String getGeneralUserToken(){
        String userName=  ConfigLoader.getProperty("generalUser.username");
        String password=  ConfigLoader.getProperty("generalUser.password");
        return generateToken(userName,password);
    }

    public static void main(String[] args) {
        System.out.println(getSupervisiorToken());
        System.out.println(getGeneralUserToken());
    }


}
