package auth;


import config.ConfigLoader;

import java.time.Instant;

public class TokenManager {

    private static String supervisiorToken;
    private static String generalUserToken;


    private static Instant supervisiorTokenGeneratedAt;
    private static Instant generalUserTokenGeneratedAt;



    private static final long TOKEN_EXPIRATION_MINUTES= ConfigLoader.getIntProperty("token.expiration.minutes");


    public static String getSupervisiorToken(){
        if(supervisiorToken == null || isTokenExpired(supervisiorTokenGeneratedAt) ){
            supervisiorToken=TokenGenerator.getSupervisiorToken();
            supervisiorTokenGeneratedAt=Instant.now();
        }
        return supervisiorToken;

    }


    public static String getgeneralUserToken(){
        if(generalUserToken == null || isTokenExpired(generalUserTokenGeneratedAt) ){
            generalUserToken=TokenGenerator.getGeneralUserToken();
            generalUserTokenGeneratedAt=Instant.now();
        }
        return generalUserToken;

    }


    private static boolean isTokenExpired(Instant generatedAt){
        if (generatedAt == null)  return true; // Token is expired if it was never generated
          Instant expirationTime=  generatedAt.plusSeconds(TOKEN_EXPIRATION_MINUTES*60);
          return Instant.now().isAfter(expirationTime);
        }


        public static void tearDown(){
        supervisiorToken = null;
        generalUserToken = null;
        supervisiorTokenGeneratedAt = null;
        generalUserTokenGeneratedAt = null;
        }

//    public static void main(String[] args) {
//        System.out.println(TokenManager.getSupervisiorToken());
//        System.out.println(TokenManager.getgeneralUserToken());
//    }

}
