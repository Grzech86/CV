package Nobilities.ex21;

import java.util.ArrayList;
import java.util.List;

//Zadanie 21 Write method boolean checkParentheses(String) that checks whether a sequence of
// races is neatly nested in each case. This should accept round, square,
// and curly braces but no other characters.
// “(( ))”, “({[ ]})”, “((( ))”,"({[ ]}())"
public class checkParentheses {


    public static boolean checkParentheses(List<Character> somethingToCheck) {
        Character element = somethingToCheck.get(0);
        somethingToCheck.remove(0);

        return internalCheckParentheses(somethingToCheck, element);
    }

    public static boolean internalCheckParentheses(List<Character> somethingToCheck, Character previous) {
        Character element = somethingToCheck.get(0);
        somethingToCheck.remove(0);

        switch (previous) {
            case '(':
                if (element == ')') {
                    return true;
                } else {
                    return internalCheckParentheses(somethingToCheck, element);
                }

            case '[':
                if (element == ']') {
                    return true;
                } else {
                    return internalCheckParentheses(somethingToCheck, element);
                }

            case '{':
                if (element == '}') {
                    return true;
                } else {
                    return internalCheckParentheses(somethingToCheck, element);
                }

            default:
                return false;
        }
    }


    public static void main(String[] args) {

        List<Character> stringToCheck = new ArrayList(List.of('(', '{', '[', ']', '}'));

        System.out.println(checkParentheses(stringToCheck));

    }
}

