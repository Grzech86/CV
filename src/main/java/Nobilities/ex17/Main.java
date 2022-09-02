package Nobilities.ex17;

public class Main {
    public static void main(String[] args) {
        boolean pal0 = Palindrome.isPalindrome(CharSymbol.toSymbols("ala ma kota"));
        System.out.println("is palindrome: " + pal0);
        boolean pal00 = Palindrome.isPalindrome(CharSymbol.toSymbols("abcba"));
        System.out.println("is palindrome: " + pal00);
        boolean pal1 = Palindrome.isPalindrome(DigitSymbol.toSymbols(12321));
        System.out.println("is palindrome: " + pal1);
    }
}
