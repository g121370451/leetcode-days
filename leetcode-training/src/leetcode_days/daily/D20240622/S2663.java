package leetcode_days.daily.D20240622;

public class S2663 {
    private boolean isCallback(char[] array, int index) {
        if (index == 0) {
            return false;
        } else if (index == 1) {
            return array[index - 1] == array[index];
        } else {
            return array[index - 1] == array[index] || array[index - 2] == array[index];
        }
    }

    private int isNotThan(char[] array, int index, int k) {
        if ((int) array[index] - 'a' == k) {
            array[index] = 'a';
            --index;
        }
        return index;
    }

    public String smallestBeautifulString(String s, int k) {
        char[] array = s.toCharArray();
        int len = s.length();
        int index = len - 1;
        while ((int) array[index] - 'a' == k - 1) {
            array[index] = 'a';
            --index;
            if (index<0){
                break;
            }
        }
        if (index < 0) {
            return "";
        } else {
            ++array[index];
            while (index < len) {
                while (isNotThan(array, index, k) == index - 1) {
                    index = index - 1;
                    if (index<0){
                        return "";
                    }
                    ++array[index];
                }
                if (isCallback(array, index)) {
                    ++array[index];
                }else{
                    ++index;
                }
            }
            return new String(array);
        }
    }

    public static void main(String[] args) {
        S2663 s2663 = new S2663();
//        System.out.println(s2663.smallestBeautifulString("abcz", 26));
        System.out.println(s2663.smallestBeautifulString("dc", 4));
    }
}
