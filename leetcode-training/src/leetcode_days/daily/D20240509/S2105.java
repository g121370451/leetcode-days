package leetcode_days.daily.D20240509;

public class S2105 {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int i = 0, j = plants.length - 1;
        int currentCapacityA = capacityA;
        int currentCapacityB = capacityB;
        while (i < j) {
            if (currentCapacityA >= plants[i]) {
                currentCapacityA -= plants[i];
            } else {
                currentCapacityA = capacityA - plants[i];
                ++res;
            }
            if (currentCapacityB >= plants[j]) {
                currentCapacityB -= plants[j];
            } else {
                currentCapacityB = capacityB - plants[j];
                ++res;
            }
            i++;
            j--;
        }
        if (i == j) {
            int max = Math.max(currentCapacityA, currentCapacityB);
            if (max < plants[i]) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2105 s2105 = new S2105();
        int[] plants = {2, 2, 3, 3};
        int capacityA = 5, capacityB = 5;
        int i = s2105.minimumRefill(plants, capacityA, capacityB);
        System.out.println(i);
    }
}
