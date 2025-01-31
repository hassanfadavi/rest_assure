package config;

import io.restassured.RestAssured;
import utils.ConfigUtillities;

import static config.ConfigLoader.properties;

public enum Environment {


    DEV("https://bookstore.demoqa.com"),
    QA("http://localhost:3000"),
    PROD("https://bookstore.demoqa.com");



  private  final String baseUrl;

    Environment(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public static Environment getCurrentEnvironment(){

       return Environment.valueOf(ConfigUtillities.getEnvironment().trim().toUpperCase());


    }

//    public static void main(String[] args) {
//        System.out.println( ConfigLoader.getProperty("environment"));
//
//        Environment currentEnv = Environment.getCurrentEnvironment();
//        System.out.println(currentEnv.getBaseUrl());
//
//    }







}
