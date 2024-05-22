package leetcode_days.weekly.W20240519;


public class S100308 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
//        Arrays.sort(queries, (a, b) -> {
//            if (a[0] == b[0]) {
//                return a[1] - b[1];
//            }
//            return a[0] - b[0];
//        });
        int i;
        int j;
        int flag;
        boolean res_temp;
        for (int index = 0; index < queries.length; index++) {
            for (int[] query : queries) {
                i = query[0];
                j = query[1];
                flag = nums[i++] % 2;
                res_temp = true;
                for (; i <= j; i++) {
                    if (flag!=nums[i] % 2){
                        flag = nums[i] % 2;
                    }else{
                        res_temp = false;
                        break;
                    }
                }
                res[index++] = res_temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S100308 s100308 = new S100308();
        int[] nums = {3, 8, 9, 3, 8};
//        int[][] queries = {{2,3}, {2, 3}, {0, 1}};
        int[][] queries = {{2, 3}};
        for (boolean b : s100308.isArraySpecial(nums, queries)) {
            System.out.println(b);
        }
    }
}
