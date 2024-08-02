package leetcode_days.daily.D20240630;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S494 {
    Map<Integer,Integer>[] mark;
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        mark = new HashMap[len];
        Map<Integer,Integer> temp;
        temp = new HashMap<>();
        temp.put(nums[len-1],1);temp.put(-nums[len-1],temp.getOrDefault(-nums[len-1],0)+1);
        mark[len - 1]= temp;
        for(int i=len-2;i>=0;i--){
            temp = new HashMap<>();
            Map<Integer,Integer> pre =  mark[i+1];
            for (Map.Entry<Integer, Integer> entry : pre.entrySet()) {
                temp.put(entry.getKey() + nums[i],temp.getOrDefault(entry.getKey() + nums[i],0)+entry.getValue());
                temp.put(entry.getKey() - nums[i],temp.getOrDefault(entry.getKey() - nums[i],0)+entry.getValue());
            }
            mark[i]=temp;
        }
        return mark[0].getOrDefault(target,0);
    }

    public static void main(String[] args) {
        S494 s494 = new S494();
//        System.out.println(s494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(s494.findTargetSumWays(new int[]{1}, 2));
    }
}
