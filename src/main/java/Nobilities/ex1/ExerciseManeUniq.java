package Nobilities.ex1;
//Implement an algorithm to determine if a string has all unique characters.

public class ExerciseManeUniq {
    public static boolean unique(String left) {
        for (int i = 0; i < left.length() - 1; i++) {
            for (int j = i + 1; j < left.length(); j++) {
                if (left.charAt(i) == left.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String input1 = "left";

        boolean unique = unique(input1);

        System.out.println("unique: " + unique);
    }


}