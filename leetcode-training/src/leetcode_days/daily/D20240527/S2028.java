package leetcode_days.daily.D20240527;

import java.util.Arrays;

public class S2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length + n;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int elseNum = mean * len - sum;
        int[] res = new int[n];
        int elseOneNum = elseNum / n;
        if (elseOneNum < 1 || elseOneNum > 6) {
            return new int[0];
        }
        Arrays.fill(res, elseOneNum);
        int elseTotalNum = elseNum - elseOneNum * n;
        int index = 0;
        while (elseTotalNum > 0 && index < n) {
            if (res[index] <6){
                ++res[index];
                --elseTotalNum;
            }else{
                ++index;
            }
        }
        if(elseTotalNum == 0){
            return res;
        }else{
            return new int[0];
        }
    }

    public static void main(String[] args) {
        S2028 s2028 = new S2028();
//        int[] nums = {3,2,4,3};
//        int[] nums = {3,5,3};
        int[] nums = {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
//        int mean = 4;
//        int mean = 5;
        int mean = 2;
//        int k = 2;
//        int k = 3;
        int k = 53;
        int[] ints = s2028.missingRolls(nums, mean, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
