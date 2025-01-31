package utils;

import config.ConfigLoader;

public class RandomEmailGenerator {
    /*
     * Create a method that generates random email addresses.
     * Ensure that the same email address is not generated twice (no duplicate emails).
     * Allow the domain of the email address to be set by the user.
     * For example, the email should end with @TekSchool.com or @java.com.
     */



    public static String   generateRandomEmail( ){

        return  "test"+System.currentTimeMillis()+ "@" + ConfigUtillities.getEmailDomain();

    }

    public static void main(String[] args) throws InterruptedException {

        for(int i=1;i<=5; i++   ){
            System.out.println(i+": "+generateRandomEmail( ));
            Thread.sleep(100);
        }
    }


}


