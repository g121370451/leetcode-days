package leetcode_days.weekly.W20240704;

public class S1000359 {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] mark = new int[m][n][2];
        int res = 0;
        int x = 0;
        int y = 0;
        for(int j=0;j<n;j++){
            if(grid[0][j]=='X'){
                ++x;
            }else if(grid[0][j]=='Y'){
                ++y;
            }
            if(x!=0&&x==y){
                ++res;
            }
            mark[0][j][0] =x;
            mark[0][j][1] = y;
        }
        int x_pre;
        int y_pre;
        for(int i = 1;i<m;i++){
            x=0;
            y=0;
            for(int j= 0;j<n;j++){
                x_pre=mark[i-1][j][0];
                y_pre=mark[i-1][j][1];
                if(grid[i][j]=='X'){
                    ++x;
                }else if(grid[i][j]=='Y'){
                    ++y;
                }
                if(x+x_pre!=0&&x+x_pre==y+y_pre){
                    ++res;
                }
                mark[i][j][0] = x+x_pre;
                mark[i][j][1] = y+y_pre;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S1000359 s1000359 = new S1000359();
        System.out.println(s1000359.numberOfSubmatrices(new char[][]{{'.', '.', '.'}, {'.', 'X', 'X'}, {'Y', '.', '.'}, {'X', '.', '.'}}));
    }
}
