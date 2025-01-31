package api.api.bookStore;

import api.api.common.EndPoints;
import auth.TokenGenerator;
import config.ConfigLoader;
import data.DataLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookStoreAPI {


    public static Response getAllBooks() {

        return RestAssured
                .given()
                .get(EndPoints.GET_ALL_BOOKS);

    }


    public static Response getSpecificBook(String isbn) {

        return RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get(EndPoints.GET_SPECIFIC_BOOK +isbn);

    }

    public static Response postBooks() {

        String userId= DataLoader.getProperty("userId");
        String isbn= DataLoader.getProperty("isbn");
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken())
                .body("{\n" + "  \"userId\": \"" + userId + "\",\n" + "  \"collectionOfIsbns\": [\n" +
                        "    {\n" +
                        "      \"isbn\": \"" + isbn + "\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")

                .post(EndPoints.POST_BOOKS);

    }


    public static Response updateBooks() {
        String userId= DataLoader.getProperty("userId");
        String isbnNew= DataLoader.getProperty("isbnNew");
        String isbnOld= DataLoader.getProperty("isbn");
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken())
                .body("{ \"userId\": \"" + userId + "\", \"isbn\": \"" + isbnNew + "\" }")
                .put(EndPoints.PUT_BOOKS+isbnOld);
    }


    public static Response deleteBooks() {
        String userId= DataLoader.getProperty("userId");
        String isbn= DataLoader.getProperty("isbn");
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.getSupervisiorToken()) // Add the Authorization header
                .body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\" }")
                .delete(EndPoints.DELETE_BOOKS);
    }


    //*********this methods is created for AllTests Class*******************************
    public static Response postBooksForAllStudents(String userId,String isbn,String userName,String password) {

        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password)) // Add the Authorization header
                .body("{\n" + "  \"userId\": \"" + userId + "\",\n" + "  \"collectionOfIsbns\": [\n" +
                        "    {\n" +
                        "      \"isbn\": \"" + isbn + "\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")

                .post(EndPoints.POST_BOOKS);

    }


    public static Response updateBooksRandom(String userId,String isbnNew,String isbnOld,String userName,String password) {
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password)) // Add the Authorization header
                .body("{ \"userId\": \"" + userId + "\", \"isbn\": \"" + isbnNew + "\" }")
                .put(EndPoints.PUT_BOOKS+isbnOld);
    }

    public static Response deleteBooksForAllTest(String userId,String isbn,String userName,String password) {
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password)) // Add the Authorization header
                .body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\" }")
                .delete(EndPoints.DELETE_BOOKS);
    }


    public static void main(String[] args) {

    }

    public static Response deleteBooksBaseOnUSERIDForAllTest(String userId,String userName,String password) {
        return RestAssured
                .given()
                . contentType("application/json")
                .header("Authorization", "Bearer " + TokenGenerator.generateToken(userName,password))
//                .pathParams("UUID",userId)
                .delete(EndPoints.DELETE_BOOKS_USERID+userId);
    }

}