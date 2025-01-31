package utils;

import java.util.Random;

public class RandomUserName_Password {


//    public static String generateUserName() {
//        return "user" + System.currentTimeMillis();
//    }
    public static String generatePass() {
        return "User@" + System.currentTimeMillis() + "$!";
    }

    public static String generateUserName() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder username = new StringBuilder("Dave");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            username.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return username.toString();
    }

//    public static String generatePass() {
//        String uppercase = "ABCDE";
//        String lowercase = "abcde";
//        String digits = "0123456789";
//        String special = "!@$&";
//        String all = uppercase + lowercase + digits + special;
//        StringBuilder password = new StringBuilder(8);
//        Random random = new Random();
//        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
//        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
//        password.append(digits.charAt(random.nextInt(digits.length())));
//        password.append(special.charAt(random.nextInt(special.length())));
//
//        for (int i = 4; i <8; i++) {
//            password.append(all.charAt(random.nextInt(all.length())));
//
//        }
//        return password.toString();
//    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            System.out.println(i+": "+ "userName: "+generateUserName()+"   password: " +generatePass());
            Thread.sleep(100);
        }


    }


}
