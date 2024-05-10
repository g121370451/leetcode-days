package leetcode_days.hot_100.matrix;

import java.util.ArrayList;
import java.util.List;

// 54.螺旋矩阵
public class S54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int len = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(len);
        int i = 0, j = -1;
        int startI = 0, endI = matrix.length - 1;
        int startJ = 0, endJ = matrix[0].length - 1;
        while (res.size() != len) {
            if (i == startI && j == startJ - 1) {
                j = startJ;
                while (j < endJ) {
                    res.add(matrix[i][j++]);
                }
                res.add(matrix[i][j]);
                ++startI;
            } else if (i == endI && j == endJ + 1) {
                j = endJ;
                while (j > startJ) {
                    res.add(matrix[i][j--]);
                }
                res.add(matrix[i][j]);
                --endI;
            } else if (j == endJ && i == startI - 1) {
                i = startI;
                while (i < endI) {
                    res.add(matrix[i++][j]);
                }
                res.add(matrix[i][j]);
                --endJ;
            } else if (j == startJ && i == endI + 1) {
                i = endI;
                while (i > startI) {
                    res.add(matrix[i--][j]);
                }
                res.add(matrix[i][j]);
                ++startJ;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S54 s54 = new S54();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; //[1,2,3,6,9,8,7,4,5]
//        int[][] matrix = {{2, 5, 8}, {4, 0, -1}}; //[2,5,8,-1,0,4]
        //1236987458
        List<Integer> integers = s54.spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }
}
