package Nobilities.ex15.ex3;

import java.util.Arrays;

public class Palindrome {

    public static boolean isPalindome(String left,String right) {
        for (int i = 0; i < left.length() / 2; i++)
            if (left.charAt(i) != left.charAt(left.length() - 1 - i)) {
                return false;
        }
        if (left.length() != right.length()) {
            return false;
        }
        char[] leftsort = left.toCharArray();
        Arrays.sort(leftsort);
        String sorted1 = String.valueOf(leftsort);

        char[] rightsort = right.toCharArray();
        Arrays.sort(rightsort);
        String sorted2 = String.valueOf(rightsort);

        return sorted1.equals(sorted2);
    }
        public static void main (String[]args){
            String left = "potop";
            String right = "potpo";
            boolean isPalindom = isPalindome(left, right);
            System.out.println("IsPalindom: " + isPalindom);
        }
    }