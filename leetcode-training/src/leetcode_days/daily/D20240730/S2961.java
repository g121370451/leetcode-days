package leetcode_days.daily.D20240730;

import java.util.ArrayList;
import java.util.List;

public class S2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<variables.length;i++){
            if(variables[i][3] < target){
                continue;
            }
            if(pow(pow(variables[i][0],variables[i][1],10),variables[i][2],variables[i][3]) == target){
                res.add(i);
            }
        }
        return res;
    }
    private int pow(int x,int n,int mod){
        if(n == 1){
            return x % mod;
        }else if(n == 2){
            return x * x % mod;
        }else if(n%2 == 0){
            return pow(x,n/2,mod) * pow(x,n/2,mod) % mod;
        }else{
            return pow(x,n/2,mod) * pow(x,n/2,mod) * x % mod;
        }
    }

    public static void main(String[] args) {
        S2961 s2961 = new S2961();
        int[][] nums = new int[][]{{6,4,3,5},{7,4,2,6},{1,4,2,1},{4,5,4,5},{7,2,2,7},{7,5,4,3},{2,7,1,3},{6,7,2,2},{4,7,4,1},{7,3,2,1}};
        for (Integer goodIndex : s2961.getGoodIndices(nums, 1)) {
            System.out.println(goodIndex);
        }
    }
}
