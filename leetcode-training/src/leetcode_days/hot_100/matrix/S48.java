package leetcode_days.hot_100.matrix;

public class S48 {

    public void rotate(int[][] matrix) {
        int temp;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int k = 0; k < len; k++) {
            int i = 0, j = len - 1;
            while (i < j) {
                temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
                ++i;
                --j;
            }

        }
    }

    public static void main(String[] args) {
        S48 s48 = new S48();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        s48.rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
