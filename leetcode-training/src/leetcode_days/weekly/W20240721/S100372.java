package leetcode_days.weekly.W20240721;

public class S100372 {
    public int minChanges(int n, int k) {
        int res=0;
        while (n > 0 && k > 0) {
            int n_temp = n & 1;
            System.out.println(n_temp);
            int k_temp = k & 1;
            if(n_temp == 0 && k_temp == 1){
                return -1;
            }else if(n_temp == 1 && k_temp == 0){
                res++;
            }
            n = n>>1;
            k = k>>1;
        }
        if(k>0){
            return -1;
        }else{
            while(n>0){
                if((n&1) == 1){
                    ++res;
                }
                n = n>>1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S100372 s100372 = new S100372();
        System.out.println(s100372.minChanges(13, 4));
    }
}
