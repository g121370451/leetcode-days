package leetcode_days.weekly.W20240630;

public class S100340 {
    public int maxHeightOfTriangle(int red, int blue) {
        int res = 0;
        int low = Math.min(red,blue);
        int high = Math.max(red,blue);
        int a =1,b=2;
        int sum_a= 0,sum_b=0;
        while(true){
            if((res+1)%2!=0){
                sum_a+=a;
                a+=2;
                if(sum_a<=high && sum_b<=low){
                    ++res;
                }else{
                    return res;
                }
            }else{
                sum_b+=b;
                b+=2;
                if(sum_b<=high && sum_a<=low){
                    ++res;
                }else{
                    return res;
                }
            }
        }
    }

    public static void main(String[] args) {
        S100340 s100340 = new S100340();
        System.out.println(s100340.maxHeightOfTriangle(2, 4));
    }
}
