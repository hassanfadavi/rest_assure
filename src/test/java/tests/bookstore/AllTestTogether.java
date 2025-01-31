package tests.bookstore;

import api.api.account.AccountAPI;
import api.api.bookStore.BookStoreAPI;
import api.api.common.CommanMessages;
import api.api.common.ErrorMessage;
import api.api.common.StatusCodes;
import base.BaseTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTestTogether extends BaseTest {



    public static String firstBookIsbn;
    public static String socondBookIsbn;

    public static String updateBookIsbn;
    public static String generatedUserName;
    public static String generatePassword;
    public static String userID;
    public static JsonPath jsonPath;
    private static  Response response;

    // if you Beforeeach ,it casue to make generate user and password for ach test case


   @BeforeAll
   public static void  prepare(){
          generatedUserName = AccountAPI.generateUserName();
           generatePassword = AccountAPI.generatePassword();
//       response = AccountAPI.createUserRandomName(generatedUserName, generatePassword);
   }

    @Test
    @Order(1)
    public void testCreateUser() {
        response = AccountAPI.createUserRandomName(generatedUserName, generatePassword);
        assertEquals(StatusCodes.TWO_ZERO_ONE, response.statusCode(), ErrorMessage.CREATE_USER_REQUEST_FAILED);
        JsonPath jsonPath = response.jsonPath();
        userID = jsonPath.getString("userID");
        System.out.println( response.statusCode());
        System.out.println( response.asPrettyString());
    }


    @Test
    @Order(2)
    public void testGetAllBooks(){
        response = BookStoreAPI.getAllBooks();
        System.out.println(response.asPrettyString());
        assertEquals(StatusCodes.TWO_ZERO_ZERO,response.statusCode(),ErrorMessage.REQUEST_FAILED);
        jsonPath = response.jsonPath();
         firstBookIsbn = jsonPath.getString("books[0].isbn");
        socondBookIsbn = jsonPath.getString("books[0].isbn");
        updateBookIsbn = jsonPath.getString("books[1].isbn");
    }
    @Test
    @Order(3)
    public void testGetSpecificBookBaseOnisbn(){
        response = BookStoreAPI.getSpecificBook(firstBookIsbn);
        System.out.println(response.asPrettyString());
        assertEquals(StatusCodes.TWO_ZERO_ZERO,response.statusCode(),ErrorMessage.REQUEST_FAILED);
        assertNotNull(response.jsonPath().getString("isbn"),"isbn is null");
    }


    @Test
    @Order(4)
    public void testPostBooks(){
        System.out.println(generatedUserName);
        System.out.println(userID);
        response = BookStoreAPI.postBooksForAllStudents(userID,firstBookIsbn, generatedUserName,generatePassword);
        System.out.println(response.asPrettyString());
        assertEquals(StatusCodes.TWO_ZERO_ONE,response.statusCode(),ErrorMessage.REQUEST_FAILED);
    }
    @Test
    @Order(5)
    public void testUpdateBooks(){
        response = BookStoreAPI.updateBooksRandom(userID,updateBookIsbn,firstBookIsbn,generatedUserName,generatePassword);
        System.out.println(response.asPrettyString());
        assertEquals(StatusCodes.TWO_ZERO_ZERO,response.statusCode(),ErrorMessage.REQUEST_FAILED);
    }
//    @Test
//    @Order(6)
//    public void testDeleteBooksForAllTest(){
//        Response response = BookStoreAPI.deleteBooksForAllTest(userID,updateBookIsbn,generatedUserName,generatePassword);
//        System.out.println(response.asPrettyString());
//        assertEquals(204,response.statusCode(),"Request got failed");
//    }
//

    @ AfterAll
    public static void tearDowns(){

        response = BookStoreAPI.deleteBooksBaseOnUSERIDForAllTest(userID,generatedUserName,generatePassword);
        System.out.println(response.asPrettyString());
        assertEquals(StatusCodes.TWO_ZERO_FOUR,response.statusCode(),ErrorMessage.REQUEST_FAILED);
        System.out.println(CommanMessages.USER_DELETED);
    }


}
