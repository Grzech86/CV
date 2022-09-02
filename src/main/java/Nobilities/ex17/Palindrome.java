package Nobilities.ex17;

public class Palindrome {
    public static boolean isPalindrome(Symbol[] maybePalindrome) {
        for (int i = 0; i < maybePalindrome.length / 2; ++i) {
            if (!maybePalindrome[i].compare(maybePalindrome[maybePalindrome.length - i - 1])) {
                return false;
            }
        }

        return true;
    }
}
