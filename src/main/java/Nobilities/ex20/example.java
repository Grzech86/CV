package Nobilities.ex20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public class example {

    public static int sumator(Collection<Integer> elements) {
        Integer accumulator = 0;

        for (Integer element : elements) {
            accumulator += element;
        }

        return accumulator;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer result = sumator(list);
        System.out.println("sum is " + result);

        LinkedList<Integer> listLinked = new LinkedList<>();

        listLinked.add(1);

        Integer result1 = sumator(listLinked);
        System.out.println("sum is " + result1);

        Set<Integer> integerSet = Set.of(1, 2, 3);
        Integer result2 = sumator(integerSet);
        System.out.println("sum is " + result2);
    }
}

