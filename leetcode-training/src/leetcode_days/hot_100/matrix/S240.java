package leetcode_days.hot_100.matrix;

//240. 搜索二维矩阵 II
public class S240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int len_i = matrix.length;
        int i = 0, j = matrix[0].length - 1;
        while (i < len_i && j >= 0) {
            if (matrix[i][j] > target) {
                --j;
            } else if (matrix[i][j] < target) {
                ++i;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S240 s240 = new S240();
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix = {{-5}};
        boolean b = s240.searchMatrix(matrix, 5);
        System.out.println(b);
    }
}
