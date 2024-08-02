package leetcode_days.weekly.W20240721;

public class S100329 {
    private int setMarkN(int num){
        if(num > 0){
            return 1;
        }else if(num < 0){
            return -1;
        }else{
            return 0;
        }
    }
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        if(n == 1){
            return Math.abs(nums[0] - target[0]);
        }
        long res = 0L;
        int[] mark = new int[n];
        mark[0] = nums[0] - target[0];
        int markN = setMarkN(mark[0]);
        int nn = Math.abs(mark[0]);
        res+=nn;
        for(int i = 1;i<n;i++){
            int tempNum = nums[i] - target[i];
            int markNTemp = setMarkN(tempNum);
            tempNum = Math.abs(tempNum);
            if(markN == markNTemp){
                if(tempNum > nn){
                    res+= tempNum-nn;
                    nn = tempNum;
                }else if(tempNum <nn){
                    nn = tempNum;
                }
            }else if(markNTemp == 0){
                markN = 3;
            }else{
                nn =Math.abs(tempNum);
                markN = markNTemp;
                res+=nn;
            }
        }
        return res;
    }

    public static void main(String[] args) {
            S100329 s100329 = new S100329();
        System.out.println(s100329.minimumOperations(new int[]{9, 2, 6, 10, 4, 8, 3, 4, 2, 3}, new int[]{9, 5, 5, 1, 7, 9, 8, 7, 6, 5}));
    }
}
