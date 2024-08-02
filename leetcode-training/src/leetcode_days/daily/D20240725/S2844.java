package leetcode_days.daily.D20240725;

public class S2844 {
    int res_global;
    char[] array;
    public int minimumOperations(String num) {
        array = num.toCharArray();
        int n = array.length;
        res_global = n;
        int res = 0;
        boolean isFive = false;
        boolean isZero = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = array[i];
            if (c == '5') {
                dfs(i-1,true,false,res);
            } else if (c == '0') {
                dfs(i-1,false,true,res);
            }
            ++res;
            if (res > res_global) {
                return res_global;
            }
        }
        if (res_global == n) {
            res_global = 0;
        }
        return res_global;
    }

    private void dfs(int index, boolean isFive, boolean isZero, int res_temp) {
        for (int i = index; i >= 0; i--) {
            char c = array[i];
            if (isFive && (c == '2' || c == '7')) {
                res_global = Math.min(res_global, res_temp);
                break;
            } else if (isZero && (c == '0' || c == '5')) {
                res_global = Math.min(res_global, res_temp);
                break;
            } else {
                ++res_temp;
                if (res_temp > res_global) {
                    return;
                }
            }
        }
        if(isZero){
            res_global = Math.min(res_global, res_temp);
        }
        System.out.print(index+","+res_temp);
    }

    public static void main(String[] args) {
        S2844 s2844 = new S2844();
        System.out.println(s2844.minimumOperations("2908305"));
    }
}
