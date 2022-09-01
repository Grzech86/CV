package Nobilities.ex11;

//The Egg Drop Problem: There is a building of 100 floors. If an egg drops from the Nth floor or above, it will break. If it's dropped from any floor below, it will not break.
// You're given two eggs. Find N, while minimizing the number of drops for the worst case.

public class Egg {

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }


    public static int eggDrop(int n, int k) {

        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;


        for (i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;


        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        return eggFloor[n][k];

    }

    public static void main(String args[]) {
        int n = 2, k = 100;
        System.out.println("Rozbije się na piętrze nr " + eggDrop(n, k));
    }
}



