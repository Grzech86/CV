package Nobilities.ex29;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        final var draws = new ArrayList<Drawable>();

//        new LottoDraw(-1, "never", List.of());

        for (final var lotto : lottos) {
            draws.add(LottoDraw.decode(lotto));
        }

        final var tupleFrequencies = getTupleFrequencies(draws);

        System.out.println(tupleFrequencies);
        System.out.println(draws);
    }

    private static HashMap<List<Integer>, Integer> getTupleFrequencies(Collection<Drawable> draws) {
        final var tupleFrequencies = new HashMap<List<Integer>, Integer>();

        for (int a = 1; a <= 49 - 2; a++) {
            for (int b = a + 1; b <= 49 - 1; b++) {
                for (int c = b + 1; c <= 49; c++) {
                    final var tuple = List.of(a, b, c);
                    int counter = 0;

                    for (final var draw : draws) {
                        if (draw.contains(tuple)) {
                            counter++;
                        }
                    }

                    if (counter == 0) {
                        continue;
                    }

                    tupleFrequencies.put(tuple, counter);
                }
            }
        }
        return tupleFrequencies;
    }

    public final static String[] lottos = {
            "1. 27.01.1957 8,12,31,39,43,45",
            "2. 03.02.1957 5,10,11,22,25,27",
            "3. 10.02.1957 18,19,20,26,45,49",
            "4. 17.02.1957 2,11,14,37,40,45",
            "5. 24.02.1957 8,10,15,35,39,49",
            "6. 03.03.1957 24,26,31,35,43,47",
            "7. 10.03.1957 13,20,23,29,38,44",
            "8. 17.03.1957 8,13,15,22,38,47",
            "9. 24.03.1957 3,10,27,29,34,42",
            "10. 31.03.1957 4,5,6,13,23,25",
            "11. 07.04.1957 1,7,13,15,21,39",
            "12. 14.04.1957 2,4,31,38,39,46",
            "13. 28.04.1957 15,18,22,26,33,38",
            "14. 05.05.1957 2,4,11,18,25,48",
            "15. 12.05.1957 2,8,28,31,32,33",
            "16. 19.05.1957 10,13,19,21,32,34",
            "17. 26.05.1957 16,24,25,29,32,36",
            "18. 02.06.1957 10,11,12,31,32,33",
            "19. 09.06.1957 5,16,23,30,32,46",
            "20. 16.06.1957 3,5,11,14,33,48",
            "21. 23.06.1957 4,9,16,19,28,39",
            "22. 30.06.1957 13,19,21,24,30,36",
            "23. 07.07.1957 8,14,24,26,30,33",
            "24. 14.07.1957 1,11,14,25,44,49",
            "25. 21.07.1957 3,6,13,22,27,33",
            "26. 28.07.1957 1,13,19,21,27,35",
            "27. 04.08.1957 2,5,15,20,30,48",
            "28. 11.08.1957 4,19,21,32,34,37",
            "29. 18.08.1957 1,6,17,27,40,44",
            "30. 25.08.1957 8,20,39,41,45,49",
            "31. 01.09.1957 5,16,17,38,40,48",
            "32. 08.09.1957 6,16,21,25,43,48",
            "33. 15.09.1957 5,10,16,18,40,42",
            "34. 22.09.1957 1,15,16,19,47,48",
            "35. 29.09.1957 4,12,30,35,46,48",
            "36. 06.10.1957 2,8,9,12,16,30",
            "37. 13.10.1957 18,22,27,31,35,36",
            "38. 20.10.1957 22,24,37,40,41,45",
            "39. 27.10.1957 1,9,14,27,32,34",
            "40. 03.11.1957 13,21,28,36,39,40",
            "41. 10.11.1957 8,19,28,30,31,47",
            "42. 17.11.1957 1,7,9,14,45,48",
            "43. 24.11.1957 2,6,18,20,40,49",
            "44. 01.12.1957 5,8,14,26,32,44",
            "45. 08.12.1957 11,17,24,35,42,47",
            "46. 15.12.1957 7,12,19,36,42,49",
            "47. 22.12.1957 8,15,24,27,37,46",
            "48. 05.01.1958 2,20,22,36,37,45",
            "49. 12.01.1958 1,24,30,37,47,48",
            "50. 19.01.1958 9,15,29,33,43,44",
            "51. 26.01.1958 12,34,35,43,44,49",
            "52. 02.02.1958 1,15,29,30,31,33",
            "53. 09.02.1958 1,21,22,25,34,47",
            "54. 16.02.1958 2,8,11,39,41,45",
            "55. 23.02.1958 8,26,28,36,43,49",
            "56. 02.03.1958 11,14,19,22,23,25",
            "57. 09.03.1958 5,8,10,26,30,42",
            "58. 16.03.1958 2,6,9,36,38,42",
            "59. 23.03.1958 3,7,9,25,42,48",
            "60. 30.03.1958 4,8,10,32,42,45",
            "61. 13.04.1958 3,15,18,35,42,43",
            "62. 20.04.1958 4,5,9,19,27,32",
            "63. 27.04.1958 13,16,35,40,41,42",
            "64. 04.05.1958 4,28,38,40,45,46",
            "65. 11.05.1958 8,17,22,27,31,41",
            "66. 18.05.1958 1,2,8,17,28,40",
            "67. 25.05.1958 7,16,27,33,41,43",
            "68. 01.06.1958 1,20,41,42,43,44",
            "69. 08.06.1958 13,14,25,29,33,47",
            "70. 15.06.1958 17,23,29,39,41,45",
            "71. 22.06.1958 2,14,22,44,48,49",
            "72. 29.06.1958 3,7,13,15,16,47",
            "73. 06.07.1958 10,11,28,38,48,49",
            "74. 13.07.1958 9,16,21,24,27,35",
            "75. 20.07.1958 1,7,17,18,29,33",
            "76. 27.07.1958 19,21,22,25,36,44",
            "77. 03.08.1958 2,4,22,31,32,43",
            "78. 10.08.1958 4,9,16,26,27,46",
            "79. 17.08.1958 34,35,37,38,39,45",
            "80. 24.08.1958 17,21,27,35,41,49",
            "81. 31.08.1958 30,31,32,41,46,49",
            "82. 07.09.1958 10,16,23,26,30,39",
            "83. 14.09.1958 13,16,18,19,30,35",
            "84. 21.09.1958 9,23,26,29,31,42",
            "85. 28.09.1958 12,16,21,28,36,49",
            "86. 05.10.1958 4,11,14,23,36,44",
            "87. 12.10.1958 8,15,17,33,34,48",
            "88. 19.10.1958 1,2,13,17,37,42",
            "89. 26.10.1958 16,25,31,32,45,49",
            "90. 02.11.1958 5,8,18,21,38,39",
            "91. 09.11.1958 8,10,31,34,39,41",
            "92. 16.11.1958 11,29,31,36,44,45",
            "93. 23.11.1958 6,11,16,18,35,45",
            "94. 30.11.1958 9,21,24,25,33,39",
            "95. 07.12.1958 18,19,32,33,38,45",
            "96. 14.12.1958 1,3,10,34,35,41",
            "97. 21.12.1958 11,13,14,28,29,33",
            "98. 28.12.1958 2,22,23,33,41,43",
            "99. 04.01.1959 17,21,22,27,29,33",
            "100. 11.01.1959 4,19,21,40,42,49"
    };

    public static class LottoDraw implements Drawable {
        private final int no;
        private final String date;
        private final Collection<Integer> numbers;

        private LottoDraw(int no, String date, Collection<Integer> numbers) {
            this.no = no;
            this.date = date;
            this.numbers = numbers;
        }

        public static LottoDraw decode(String line) {
            final var segments = line.split(" ");
            final var numbers = segments[2].split(",");

            final var listOfNumbers = new ArrayList<Integer>();

            for (final var number : numbers) {
                listOfNumbers.add(Integer.valueOf(number));
            }

            return new LottoDraw(Integer.valueOf(segments[0].substring(0, segments[0].length() - 1)), segments[1], listOfNumbers);
        }

        @Override
        public boolean contains(Collection<Integer> subnumbers) {
            return this.numbers.containsAll(subnumbers);
        }
    }

    public static interface Drawable {
        boolean contains(Collection<Integer> subnumbers);
    }
}

