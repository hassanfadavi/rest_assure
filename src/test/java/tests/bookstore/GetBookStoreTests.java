//package tests.bookstore;
//
//import api.api.bookStore.BookStoreAPI;
//import base.BaseTest;
//import data.DataLoader;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class GetBookStoreTests extends BaseTest {
//
//
//    @Test
//    @Order(1)
//    public void testGetAllBooks(){
//       Response response = BookStoreAPI.getAllBooks();
////        System.out.println(response.asPrettyString());
//        assertEquals(200,response.statusCode(),"Request got failed");
//        JsonPath jsonPath = response.jsonPath();
//        String firstBooIsbn = jsonPath.getString("books[0].isbn");
//        System.out.println("First Book isbn: " + firstBooIsbn);
////        System.out.println("First Book Author: " + firstBookAuthor);
//
//    }
//
//    @Test
//    @Order(2)
//    public void testGetSpecificBookBaseOnisbn(){
//        String isbn=DataLoader.getProperty("isbn");
//        Response response = BookStoreAPI.getSpecificBook(isbn);
//        System.out.println(response.asPrettyString());
//        assertEquals(200,response.statusCode(),"request failed");
//        assertNotNull(response.jsonPath().getString("isbn"),"isbn is null");
//
//    }
//
//}
