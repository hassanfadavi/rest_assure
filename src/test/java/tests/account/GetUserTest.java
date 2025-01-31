package tests.account;

import api.api.account.AccountAPI;
import base.BaseTest;
import data.DataLoader;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserTest extends BaseTest {


    @Test
    public void getUser() {
        String userId = DataLoader.getProperty("userId");
        Response response = AccountAPI.getUser(userId);
        System.out.println(response.asPrettyString());
        assertEquals(200, response.statusCode(), "request failed");
    }


    @Test
    public void getUserWithoutToken() {
        String userId = DataLoader.getProperty("userId");
        Response response = AccountAPI.getUserWithoutToken(userId);
        System.out.println(response.asPrettyString());
        assertEquals(401, response.statusCode(), "request failed");
    }



}
