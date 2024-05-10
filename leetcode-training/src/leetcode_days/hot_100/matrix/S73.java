package leetcode_days.hot_100.matrix;

//73. 矩阵置零
public class S73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] column = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1|| column[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        S73 s73 = new S73();
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        s73.setZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
