package leetcode_days.weekly.W20240714;

import java.util.Arrays;
import java.util.Comparator;

public class S100361 {
    private void reverse(int[] array){
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // 交换元素
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // 移动指针
            left++;
            right--;
        }
    }
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int res = 0;
        Arrays.sort(horizontalCut);Arrays.sort(verticalCut);
        reverse(horizontalCut);reverse(verticalCut);
        int[] horizontalCut_sum = horizontalCut.clone();
        int[] verticalCut_sum = verticalCut.clone();
        int i=0,j=0;
        while(i<m-1 && j<n-1){
            if(horizontalCut[i] > verticalCut[j]){
                res += horizontalCut_sum[i];
                for(int inner = j;inner<n-1;inner++){
                    verticalCut_sum[inner] += verticalCut[inner];
                }
                ++i;
            }else{
                res += verticalCut_sum[j];
                for(int inner = i;inner<m-1;inner++){
                    horizontalCut_sum[inner] += horizontalCut[inner];
                }
                ++j;
            }
        }
        if(i<m-1){
            for(;i<m-1;i++){
                res += horizontalCut_sum[i];
            }
        }
        if(j<n-1){
            for(;j<n-1;j++){
                res += verticalCut_sum[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S100361 s100361  = new S100361();
        System.out.println(s100361.minimumCost(6, 3, new int[]{2,3,2,3,1}, new int[]{1,2}));
    }
}
