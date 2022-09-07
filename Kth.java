package Nobilities.ex24;

import java.util.ArrayList;
import java.util.List;

//Zadanie 24 Return Kth to Last: Implement an algorithm to find the kth to last element of a list.
// Note: do not use .get(index). One can use only .get(0). (edited)
public class Kth {


    public static <T> T kElement(Iterable<T> list, int k) {
        int size = 0;
        for (T i : list) {
            size += 1;
        }

        int index = 0;
        for (T i : list) {

            if (index == size - k) {
                return i;
            }
            index++;

        }


        return null;
    }

    public static void main(String[] args) {


        final var list = new ArrayList(List.of(1, 4, 7, 12, 20));

        final var element = kElement(list, 3);

        System.out.println(element);
    }
}
