package tests.account;

import api.api.account.AccountAPI;
import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostAuthorized extends BaseTest {

    @Test
    public void testAuthorized(){
        Response response = AccountAPI.authorized();

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
//        System.out.println("Full Response: " + response.asString());

//        assertEquals(200,response.statusCode(),"failed to authorized");
        assertEquals("true",response.asString(),"failed to authorized");


//        JsonPath jsonPath = response.jsonPath();
//        String userID = jsonPath.getString("userID");
////
//        System.out.println("userID: " + userID);
    }



}
