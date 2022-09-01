package Nobilities.ex0;

import java.util.Arrays;

public class ExerciseMane {


    public static boolean isPermutation(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        for (int i = 0; i < left.length(); i++) {
            char c = left.charAt(i);


            if (right.indexOf(c) == -1) {
                return false;
            }
            right = right.replaceFirst("" + c, "");
        }
        return true;
    }


    public static void main(String[] args) {
        String left = "abcdf";
        String right = "acbdf";
        boolean result = isPermutation(left, right);
        System.out.println("Are Permutation " + result);

    }


    public static boolean isPermutation2(String left, String right) {
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
}
