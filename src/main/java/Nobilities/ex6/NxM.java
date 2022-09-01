package Nobilities.ex6;
//Given an matrix represented by an NxM array of integers,
// write a method to rotate the matrix by 90 degrees. Can you do this in place?
public class NxM {
    // 1 2 3
    // 3 4 5
    // 6 7 8

    // 6 3 1
    // 7 4 2
    // 8 5 3
    public static void main(String[] args) {
        Demo obj = new Demo();
        /*initial matrix to rotate*/
        int[][] matrix = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
        int[][] transpose = new int[3][3];

        obj.display(matrix);

        obj.rotate(matrix, transpose);
        System.out.println();
        obj.display(transpose);
    }
}

class Demo {
    public void rotate(int[][] mat, int[][] tran) {

        /* First take the transpose of the matrix */
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                tran[i][j] = mat[j][i];
            }
        }

        /*
         * Interchange the rows of the transpose matrix to get rotated
         * matrix
         */
        for (int i = 0, j = tran.length - 1; i != j; i++, j--) {
            for (int k = 0; k < tran.length; k++) {
                swap(i, k, j, k, tran);
            }
        }
    }

    public void swap(int a, int b, int c, int d, int[][] arr) {
        int temp = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = temp;
    }

    /* Method to display the matrix */
    public void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}