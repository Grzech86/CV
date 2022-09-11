package Nobilities.ex23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Zadanie 23 Given two lists of numbers, each sorted in ascending order, merge them into a result
//        list according to their order. Write method List<Integer> merge(List<Integer>, List<Integer>).
//        Input: 1, 4, 7, 12, 20
//        Input: 10, 15, 17, 33
//        Output: 1, 4, 7, 10, 12, 15, 17, 20, 33
public class AddCol {

    public static void main(String[] args) {
        final var input = new ArrayList(List.of(1, 4, 7, 12, 20));
        final var input2 = new ArrayList(List.of(10, 15, 17, 33));

        System.out.println(merge(input, input2));
    }

    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> sorted = new LinkedList<>();

        int i = 0;
        int j = 0;

        for(;;) {
            if (i == leftList.size() && j == rightList.size()) {
                break;
            }

            final var left = (i < leftList.size()) ? leftList.get(i) : null;
            final var right = (j < rightList.size()) ? rightList.get(j) : null;

            if (left == null) {
                sorted.add(right);
                j++;
            } else if (right == null) {
                sorted.add(left);
                i++;
            } else if (left > right) {
                sorted.add(right);
                j++;
            } else {
                sorted.add(left);
                i++;
            }
        }

        return sorted;
    }
}



