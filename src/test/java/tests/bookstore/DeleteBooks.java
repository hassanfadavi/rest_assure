package tests.bookstore;

import api.api.bookStore.BookStoreAPI;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteBooks extends BaseTest {

    @Test
    public void testDeleteBooks(){
        Response response = BookStoreAPI.deleteBooks();
        System.out.println(response.asPrettyString());
        assertEquals(204,response.statusCode(),"Request got failed");
    }



}
