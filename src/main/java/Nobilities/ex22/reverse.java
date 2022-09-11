package Nobilities.ex22;

//        Zadanie 22 Implement reverse function for a collection
//        Input; {1, 4, 5, 6, 6} (edited)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class reverse {

    public static <T> List<T> reverse(List<T> list) {
        List<T> reversed = new LinkedList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            T element = list.get(i);
            reversed.add(element);
        }

        return reversed;
    }

    public static void main(String[] args) {
        final var integerRevers = new ArrayList(List.of(1, 4, 5, 6, 6));
        final var integerRevers1 = new ArrayList(List.of("a", "b", "ee", "bb"));

        final var reversedList = reverse(integerRevers);
        System.out.println(reversedList);

        final var reversedList1 = reverse(integerRevers1);
        System.out.println(reversedList1);
    }

}
