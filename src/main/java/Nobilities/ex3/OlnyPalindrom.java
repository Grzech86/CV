package Nobilities.ex3;

import java.util.Arrays;

public class OlnyPalindrom {

    public static boolean isPalindome(String left) {
        for (int i = 0;
             i < left.length() / 2; i++)
            if (left.charAt(i) != left.charAt(left.length() - 1 - i)) {
                return false;
            }
        return true;
    }
        public static void main (String[]args){
            String left = "potop";
            boolean isPalindom = isPalindome(left);
            System.out.println("IsPalindom: " + isPalindom);
        }
}