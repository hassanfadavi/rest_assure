//package tests.bookstore;
//
//import api.api.bookStore.BookStoreAPI;
//import base.BaseTest;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class UpdateBooks extends BaseTest {
//
//
//    @Test
//    @Order(1)
//    public void testUpdateBooks(){
//        Response response = BookStoreAPI.updateBooks();
//        System.out.println(response.asPrettyString());
//        assertEquals(200,response.statusCode(),"Request got failed");
//    }
//
//
//}
