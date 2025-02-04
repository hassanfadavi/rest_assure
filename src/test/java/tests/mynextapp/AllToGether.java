//package tests.mynextapp;
//
//import api.api.jsonplaceholder.my_next_app_api;
//import base.BaseTest;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.*;
//import utils.RandomEmailGenerator;
//import utils.RandomUserName_Password;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class AllToGether extends BaseTest {
//
//
//    public static JsonPath jsonPath;
//    public static String firstStudentId;
//    private static  Response response;
//    public static String generateUserName;
//    public static String generateRandomEmail;
//
//
//    @BeforeAll
//    public static void  prepare(){
//        generateUserName= RandomUserName_Password.generateUserName();
//        generateRandomEmail= RandomEmailGenerator.generateRandomEmail();
//    }
//
//    @Test
//    @Order(1)
//    public void testPostStudents(){
//
//        response = my_next_app_api.POSTStudent(generateUserName,generateRandomEmail);
//        System.out.println(response.asPrettyString());
//        System.out.println("Response Status Code: " + response.statusCode());
//        assertEquals(201,response.statusCode(),"Request got failed");
//    }
//
//
//    @Test
//    @Order(2)
//    public void testGetStudents(){
//          response = my_next_app_api.getStudents();
//        System.out.println(response.asPrettyString());
//        System.out.println("Response Status Code: " + response.statusCode());
//        assertEquals(200,response.statusCode(),"Request got failed");
//
//        jsonPath = response.jsonPath();
//        firstStudentId = jsonPath.getString("id[0]");
//        System.out.println(firstStudentId);
//    }
//
//
//    @Test
//     @Order(3)
//    public void testGetSpecificStudents(){
//
//         response = my_next_app_api.getSpecificStudent(firstStudentId);
//        System.out.println(response.asPrettyString());
//        System.out.println("Response Status Code: " + response.statusCode());
//        assertEquals(200,response.statusCode(),"Request got failed");
//    }
//
//    @AfterAll
//    public static void tearDowns(){
//        response = my_next_app_api.deleteSpecificStudent(firstStudentId);
//        System.out.println(response.asPrettyString());
//        System.out.println("Response Status Code: " + response.statusCode());
//        assertEquals(200,response.statusCode(),"Request got failed");
//        System.out.println("user is deleted");
//    }
//
//
//
//
//}
