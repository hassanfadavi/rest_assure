package utils;

import config.ConfigLoader;

public class ConfigUtillities {


    public static String getEmailDomain(){

        return ConfigLoader.getProperty("email.domain");

    }

    public static String getEnvironment(){
        return ConfigLoader.getProperty("environment");

    }



}
