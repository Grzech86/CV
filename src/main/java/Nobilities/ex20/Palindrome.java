package Nobilities.ex20;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(12321);
        list.add(1);
        list.add(12321);
        list.add(11);
        boolean result = isPalindrome(list);

        System.out.println(result);
        List<String> listOfString = List.of("ala","ma");
        isPalindrome(listOfString);

    }


    public static <T> boolean isPalindrome(List<T> maybePalindrome) {
        for (int i = 0; i < maybePalindrome.size() / 2; ++i) {
            if (!maybePalindrome.get(i).equals(maybePalindrome.get(maybePalindrome.size() - i - 1))) {
                return false;
            }

        }
        return true;
    }

}