package Nobilities.ex10;

import java.util.Map;

//Decode: .. .-.. --- ...- . .--- .- ...- .-(edited)
//ILOEAVJ
public class decodeMorse {
    public static void main(String[] args) {


        Map<String, Character> dictionary = Map.of(".-.", 'r', "..", 'i', ".-..", 'l', "---", 'o', ".", 'e', ".-", 'a', "...-", 'v', ".---", 'j');
        {
            String input = ".. .-.. --- ...- . .--- .- ...- .-";

            String decoded = "";
            String[] symbols = input.split(" ");
            for (String symbol: symbols) {
                decoded += dictionary.get(symbol);
            }

            System.out.println(decoded);

//            String decoded = "";
//            for (int i = 1, j = 0; i <= input.length(); i++) {
//                String symbol = input.substring(j,i);
//                if (!dictionary.containsKey(symbol)){
//                    String prevSymbol = input.substring(j,i - 1);
//                    char c = dictionary.get(prevSymbol);
//
//                    j = i;
//                }
//            }
        }
    }
}