//package tests.account;
//
//import api.api.account.AccountAPI;
//import api.api.bookStore.BookStoreAPI;
//import base.BaseTest;
//import data.DataLoader;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class DeleteUser extends BaseTest {
//
//    @Test
//    public void deleteUser() {
//        String userId = DataLoader.getProperty("userId");
//
//        Response response = AccountAPI.deleteUser(userId);
//        System.out.println(response.asPrettyString());
//        assertEquals(204, response.statusCode(), "request failed");
//
//
//    }
//
//    }
