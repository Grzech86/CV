package Nobilities.ex9;

import java.util.Map;

public class Morse {

    public static void main(String[] args) {
        String input = "abc";
//        .-
//                -...
//        -.-.
        Map<Character , String>  dictionary = Map.of('a',".-",'b',"-...",'c',"-.-.");
        String morse = "";
        for (char letter: input.toCharArray()){
            morse += dictionary.get(letter);

        }
        System.out.println(morse);
    }
}
