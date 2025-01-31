package tests.account;

import api.api.account.AccountAPI;
import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTestsTogetherWithRandom extends BaseTest {


    public static String generatedUserName;
    public static String generatePassword;
    public static String userID;
    private static  Response response;


   @BeforeAll
   public static void  prepare(){
       generatedUserName = AccountAPI.generateUserName();
       generatePassword = AccountAPI.generatePassword();
   }


    @Test()
    @Order(1)
    public   void testCreateUser(){
        response = AccountAPI.createUserRandomName(generatedUserName, generatePassword);

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
        assertEquals(201, response.statusCode(), "failed to create user");
        JsonPath jsonPath = response.jsonPath();
        userID = jsonPath.getString("userID");
    }
    @Test
    @Order(2)
    public void getUser() {

        Response response = AccountAPI.getUserForRandomUser(generatedUserName,generatePassword,userID);
        System.out.println(response.asPrettyString());
        assertEquals(200, response.statusCode(), "request failed");
    }
    @Test
    @Order(3)
    public void testAuthorized(){
         response = AccountAPI.authorizedForRandomName(generatedUserName, generatePassword);
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
        assertEquals("true",response.asString(),"failed to authorized");
    }


    @AfterAll
    public static void tear() {

        response = AccountAPI.deleteUserForRandomUser(generatedUserName, generatePassword, userID);
        System.out.println(response.asPrettyString());
        assertEquals(204, response.statusCode(), "request failed");
    }


}
