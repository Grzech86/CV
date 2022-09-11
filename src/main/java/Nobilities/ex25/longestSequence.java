package Nobilities.ex25;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.frequency;
import static java.util.Collections.list;

//Zadanie 25: Suppose you are modelling stock prices or altitudes of a track by a list of numbers.
//        Find the longest sequence of numbers whose values ascend or at least stay the same.
//        Write method List<Integer> findLongestGrowingSequence(List<Integer>).
//        Input: [7, 2, 7, 1, 2, 5, 7, 1]
//        Output: [1, 2, 5, 7]
public class longestSequence {

    public static void main(String[] args) {
        final var input = new ArrayList(List.of(7, 2, 7, 1, 2, 5, 7, 1));

        final var reversedSeq = findLongestGrowingSequence(input);
        System.out.println(reversedSeq);

    }

    private static List<Integer> findLongestGrowingSequence(List<Integer> list) {
        List<Integer> seq = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            Integer put = list.get(i);
            seq.add(put);
            Collections.sort(seq);
//
//            for (int j = 0; j < seq.size(); j++) {
//                if (seq.contains(j) != seq.contains(j+1)) {
//                    return seq;
//
//                }
//
//            }

        }
        return seq;
    }
}




