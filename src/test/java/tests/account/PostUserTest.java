package tests.account;

import api.api.account.AccountAPI;
import base.BaseTest;
import config.ConfigLoader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostUserTest extends BaseTest {




    @Test
    public void testCreateUser() {
        String userName = ConfigLoader.getProperty("supervisor.username");
        String password = ConfigLoader.getProperty("supervisor.password");

        Response response = AccountAPI.createUser(userName, password);
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());


            assertEquals(201, response.statusCode(), "User creation failed.");


    }



    }



