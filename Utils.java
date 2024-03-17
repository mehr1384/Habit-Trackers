package UtilityPackage;


public class Utils {
    public static boolean isPasswordValid(String password) {
        boolean Letter = false;
        boolean Digit = false;

        for (int i=0;i<password.length();i++) {
            char ch = password.charAt(i);
            if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
                Letter = true;
            } else if (ch>='0'&&ch<='9') {
                Digit = true;
            }
        }

        return Letter && Digit;
    }
}

