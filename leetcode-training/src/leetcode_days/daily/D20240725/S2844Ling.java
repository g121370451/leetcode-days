package leetcode_days.daily.D20240725;

public class S2844Ling {
    public int minimumOperations(String num) {
        int n = num.length();
        boolean found0 = false;
        boolean found5 = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (found0 && (c == '0' || c == '5') ||
                    found5 && (c == '2' || c == '7')) {
                return n - i - 2;
            }
            if (c == '0') {
                found0 = true;
            } else if (c == '5') {
                found5 = true;
            }
        }
        return found0 ? n - 1 : n;
    }

    public static void main(String[] args) {
        S2844Ling s2844 = new S2844Ling();
        System.out.println(s2844.minimumOperations("2908305"));
    }
}
