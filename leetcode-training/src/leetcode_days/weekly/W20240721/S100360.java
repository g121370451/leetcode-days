package leetcode_days.weekly.W20240721;

public class S100360 {
    private void swap(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public int maxOperations(String s) {
        char[] array = s.toCharArray();
        int res = 0;
        int n = array.length;
        int one_index = array[0]=='1'? 0:-1;
        for(int i = 1;i<n;i++){
            if(array[i] == '1'){
                if(array[i-1]=='0' && one_index != -1){
                    swap(array,i-1,one_index);
                    ++res;
                    one_index = -1;
                }
                if(i+1 < n && array[i+1] == '0'){
                    one_index = i;
                }
            }
        }
        if(one_index!= -1){
            ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        S100360 s100360 = new S100360();
        System.out.println(s100360.maxOperations("1001101"));
    }
}
