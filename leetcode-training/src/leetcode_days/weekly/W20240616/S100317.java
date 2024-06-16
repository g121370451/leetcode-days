package leetcode_days.weekly.W20240616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S100317 {
    int[] mark;
    int[][] markSearch;
    private void changeStatus(int[] nums,int index){
        if(index>0 && index < nums.length-1){
            if(mark[index]==1&& (nums[index] <= nums[index-1] || nums[index] <= nums[index+1])){
                mark[index]=0;
            }
            if(mark[index]==0 && nums[index-1] < nums[index] && nums[index+1]<nums[index]){
                mark[index]=1;
            }
        }
    }
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        mark = new int[len];
        markSearch = new int[len][len];
        mark[0] = 0;
        for(int i =1;i<nums.length-1;i++){
            if(nums[i-1] < nums[i] && nums[i+1]<nums[i]){
                mark[i] = 1;
            }
        }
        for(int[] search:markSearch){
            Arrays.fill(search,-1);
        }
        for(int[] query:queries){
            if(query[0]==2){
                if(nums[query[1]]==query[2]){
                    continue;
                }
                for(int[] search:markSearch){
                    Arrays.fill(search,-1);
                }
                nums[query[1]] = query[2];
                changeStatus(nums,query[1]-1);
                changeStatus(nums,query[1]);
                changeStatus(nums,query[1]+1);
            }else if(query[0]==1){
                int left = query[1];
                int right = query[2];
                if(markSearch[left][right]!=-1){
                    res.add(markSearch[left][right]);
                    continue;
                }
                int res_temp = 0;
                for(int temp = left+1;temp<right;temp++){
                    if(mark[temp]!=0){
                        ++res_temp;
                    }
                }
                res.add(res_temp);
                markSearch[left][right] = res_temp;
            }
        }
        return res;
    }
}
