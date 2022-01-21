package common;

import java.util.regex.Pattern;

public class Check {
    public static boolean checkIdCustomer(String string) {
        String regex = "^KH-\\d{4}";
        return Pattern.matches(regex, string);
    }
    public  static boolean checkIdService(String string){
        String regex = "^DV-\\d{4}";
        return Pattern.matches(regex, string);
    }
    public static boolean checkEmailException(String myString) {
        String regex ="^[\\p{L}\\p{N}\\._%+-]+@[\\p{L}\\p{N}\\.\\-]+\\.[\\p{L}]{2,}$";
        return Pattern.matches(regex, myString);
    }

}