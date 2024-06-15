package leetcode_days.daily.D20240611;

public class S419 {
    public int countBattleships(char[][] board) {
        int i = 1, j = 1;
        int iLen = board.length;
        int jLen = board[0].length;
        int res = board[0][0] == 'X' ? 1 : 0;
        while (j < jLen) {
            if (board[0][j]=='X' && board[0][j] != board[0][j - 1]) {
                ++res;
            }
            ++j;
        }
        while (i < iLen) {
            j = 0;
            while (j < jLen) {
                if (board[i][j] == 'X') {
                    if (board[i - 1][j] != 'X') {
                        if (j - 1 < 0) {
                            ++res;
                        } else if (board[i][j - 1] != 'X') {
                            ++res;
                        }
                    }
                }
                ++j;
            }
            ++i;
        }
        return res;
    }

    public static void main(String[] args) {
        S419 s419 = new S419();
//        System.out.println(s419.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
        System.out.println(s419.countBattleships(new char[][]{{'.', '.'}, {'X', 'X'}}));
    }
}
