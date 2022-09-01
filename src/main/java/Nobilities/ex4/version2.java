package Nobilities.ex4;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

    public class version2 {
        public static boolean isEven(Integer value) {
            return value % 2 == 0;
        }

        public static boolean isPermutationOfPalindrome(String input) {
            Map<Character, Integer> counter = new HashMap<>();

            String cleaned = input
                    .replaceAll("\s", "")
                    .toLowerCase(Locale.ROOT);

            for (char c : cleaned.toCharArray()) {
                counter.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
            }

            boolean wasOdd = false;

            for (Integer v : counter.values()) {
                if (isEven(v)) {
                    continue;
                }
                if (wasOdd) {
                    return false;
                }
                wasOdd = true;
            }

            return true;
        }

        public static void main(String[] args) {
            String input = "Tact Coa";
            boolean result = isPermutationOfPalindrome(input);

            System.out.println("Result: " + result);
        }
    }
