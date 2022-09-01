package Nobilities.ex4;

import java.util.HashMap;
import java.util.Map;

public class PerPalind {

    public static boolean isPermutationOfPalindrome(String input) {
        Map<Character, Integer> counter = new HashMap<>();
        Integer sLength = 0;
        for (int i = 0; i < input.length(); i++) {
                    char c = input.toLowerCase().charAt(i);
                    if (c == ' ') {
                        continue;
                    }
                    sLength++;
                    Integer oldCounter = counter.getOrDefault(c, 0);
                    Integer newCounter = (oldCounter == null) ? 1 : oldCounter + 1;
                    counter.put(c, oldCounter);
                }
                if (sLength % 2 == 1) {
                    boolean flag = false;
                    for (Map.Entry<Character, Integer> e : counter.entrySet()) {
                        if (e.getValue() % 2 == 0) {
                            continue;
                        }
                        if (!flag) {
                            flag = true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    for (Map.Entry<Character, Integer> e : counter.entrySet()) {
                        if (e.getValue() % 2 == 1) {
                            return false;
                        }
                    }
                }
                return true;
            }
            public static void main(String[] args) {
                String input = "Tact Cora";
                boolean result = isPermutationOfPalindrome(input);
                System.out.println("Result: " + result);
            }
}



