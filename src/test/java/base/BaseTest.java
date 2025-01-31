package base;

import auth.TokenManager;
import config.ConfigLoader;
import config.Environment;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



public class BaseTest {

    @BeforeEach
    public  void setUp(){

        Environment currentEnv = Environment.getCurrentEnvironment();
        RestAssured.baseURI =currentEnv.getBaseUrl();
        int timeOuts= ConfigLoader.getIntProperty("timeouts");

        RestAssured.config = RestAssured.config().httpClient(
                RestAssured.config().getHttpClientConfig().setParam("http.connection.timeout", timeOuts)

        );
//
        System.out.println(currentEnv);
        System.out.println(RestAssured.baseURI);
        System.out.println(timeOuts);

    }



    @AfterEach
    public void tearDown(){
        TokenManager.tearDown();
        System.out.println("tokens are cleared after test completion");


    }

//    public static void main(String[] args) {
//        setUp();
//    }


}
