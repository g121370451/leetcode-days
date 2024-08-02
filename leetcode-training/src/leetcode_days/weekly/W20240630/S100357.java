package leetcode_days.weekly.W20240630;

public class S100357 {
    int[][][] mark;
    public int maximumLength(int[] nums) {
        int len = nums.length;
        mark = new int[len][2][2];
        // for(int[][] array :mark){
        //     for(int[] a :array){
        //         Arrays.fill(-1);
        //     }
        // }
        mark[len-1][nums[len-1] % 2][0]=1;
        mark[len-1][nums[len-1] % 2][1]=1;
        dfs(nums,len-2);
        int max =  Math.max(mark[0][0][0],mark[0][0][1]);
        max = Math.max(max,mark[0][1][0]);
        max = Math.max(max,mark[0][1][1]);
        return max;
    }
    private void dfs(int[] nums,int index){
        if(index<0){
            return;
        }
        mark[index][nums[index] % 2][0] = mark[index+1][nums[index] % 2][0] +1;
        mark[index][nums[index] % 2][1] = mark[index+1][(nums[index] % 2)^1][1] + 1;
        mark[index][(nums[index]%2)^1][0] = mark[index+1][(nums[index]%2)^1][0];
        mark[index][(nums[index]%2)^1][1] = mark[index+1][(nums[index]%2)^1][1];
        dfs(nums,index-1);
    }

    public static void main(String[] args) {
        S100357 s100357 = new S100357();
        System.out.println(s100357.maximumLength(new int[]{1, 2, 3, 4}));
        System.out.println(s100357.maximumLength(new int[]{2,39,23}));
    }
}
