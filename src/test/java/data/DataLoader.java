package data;

import config.ConfigLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataLoader {

    static final Properties properties=new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(
                "data/data.properties")) {
            if(input == null) {
                throw new RuntimeException("Either you don't have data.properties or data.properties is empty! (src/test/resources/data/)");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration from: data/data.properties");
        }

    }
    private static  boolean checkIfPropertyIsNullOrIsEmpty(String key){
        return  properties.getProperty(key) == null  || properties.getProperty(key).equals(" ") ;

    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }



    public static Properties getProperties(){
        return properties;
    }

    public static boolean getBooleanProperty (String key){

        return  (checkIfPropertyIsNullOrIsEmpty(key))?
                false :
                Boolean.parseBoolean(properties.getProperty(key));

    }




}
