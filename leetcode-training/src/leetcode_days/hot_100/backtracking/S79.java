package leetcode_days.hot_100.backtracking;

public class S79 {
    char[] array;
    char[][] board;
    int[][] isUsed;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        array = word.toCharArray();
        this.board = board;
        m = board.length;
        n = board[0].length;
        isUsed = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (board[i][j] == array[index]) {
            isUsed[i][j] = 1;
            ++index;
            if (index == array.length) {
                return true;
            }
            if (i - 1 >= 0 && isUsed[i-1][j]==0 && dfs(i - 1, j, index)) {
                return true;
            }
            if (i + 1 < m && isUsed[i+1][j]==0 && dfs(i + 1, j, index)) {
                return true;
            }
            if (j - 1 >= 0 && isUsed[i][j-1]==0 && dfs(i, j - 1, index)) {
                return true;
            }
            if (j + 1 < n && isUsed[i][j+1]==0 && dfs(i, j + 1, index)) {
                return true;
            }
            isUsed[i][j]=0;
        }
        return false;
    }

    public static void main(String[] args) {
        S79 s79 = new S79();
        System.out.println(s79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
