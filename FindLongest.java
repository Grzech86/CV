package Nobilities.ex26;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FindLongest {
    private static Collection<Integer> findLongestGrowingSequence(Iterator<Integer> input) {
        Integer prevElement = null;
        Collection<Integer> current = new ArrayList<>();
        Collection<Integer> longest = new ArrayList<>();

        while (input.hasNext()) {
            Integer element = input.next();

            if (prevElement != null && prevElement > element) {
                if (longest.size() < current.size()) {
                    longest = current;
                }
                current = new ArrayList<>();
            }

            current.add(element);
            prevElement = element;
        }

        if (longest.size() < current.size()) {
            longest = current;
        }

        return longest;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList(List.of(7, 2, 7, 1, 2, 5, 7));

        Collection<Integer> longestGrowingSequence = findLongestGrowingSequence(list.iterator());
        System.out.println(longestGrowingSequence);
    }
}
