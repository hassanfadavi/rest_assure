package config;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Optional;
import java.util.Properties;

public class ConfigLoader {

  static final  Properties properties=new Properties();


  static {
      try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(
              "config/config.properties")) {
          if(input == null) {
              throw new RuntimeException("Either you don't have config.properties or config.properties is empty! (src/test/resources/config/)");
          }
          properties.load(input);
      } catch (IOException e) {
          throw new RuntimeException("Failed to load configuration from: config/config.properties");
      }

  }

    private static  boolean checkIfPropertyIsNullOrIsEmpty(String key){
        return  getProperty(key) == null  || getProperty(key).equals(" ") ;

    }


  public static String getProperty(String key){

       return properties.getProperty(key);
  }

    public static int  getIntProperty(String key){
        return  (checkIfPropertyIsNullOrIsEmpty(key)) ?
                5000 :
                Integer.parseInt(getProperty(key));


    }


    public static Properties getProperties(){
      return properties;
    }

    public static boolean getBooleanProperty (String key){

//      return Boolean.parseBoolean(properties.getProperty(key))  ;

      return  (checkIfPropertyIsNullOrIsEmpty(key))?
              false :
              Boolean.parseBoolean(properties.getProperty(key));

        }






    }


