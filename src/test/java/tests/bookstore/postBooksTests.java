//package tests.bookstore;
//
//import api.api.bookStore.BookStoreAPI;
//import base.BaseTest;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class postBooksTests extends BaseTest {
//
//    @Test
//    public void testPostBooks(){
//        Response response = BookStoreAPI.postBooks();
//        System.out.println(response.asPrettyString());
//        assertEquals(201,response.statusCode(),"Request got failed");
//    }
//
//
//}
