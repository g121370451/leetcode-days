package leetcode_days.data_struct;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ListNode {
    public Integer val;
    public ListNode next;

    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    public ListNode() {
        this.val = null;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildRandomWithHead(int length, int startVal, int endVal) {
        return buildRandomList(length, startVal, endVal, true);
    }

    public static ListNode buildRandomWithoutHead(int length, int startVal, int endVal) {
        return buildRandomList(length, startVal, endVal, false);
    }

    private static ListNode buildRandomList(int length, int startVal, int endVal, boolean hasHead) {
        ListNode res = new ListNode();
        if (!hasHead) {
            res.val = getRandom().nextInt(startVal, endVal);
            --length;
        }
        ListNode index = res;
        while (length > 0) {
            index = index.next = new ListNode(getRandom().nextInt(startVal, endVal));
            --length;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildRandomWithHead(5, 1, 10);
        System.out.println(listNode);
    }

    // 1->1->2
    public static ListNode buildTest1() {
        return new ListNode(1, new ListNode(1, new ListNode(2)));
    }


    // 1->1->2->3->3
    public static ListNode buildTest2() {
        return new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
    }

    //
    public static ListNode buildTest3() {
        return new ListNode();
    }

    public static ListNode buildSpecialWithHead(int[] nums) {
        return buildSpecial(nums, true);
    }

    public static ListNode buildSpecialWithoutHead(int[] nums) {
        return buildSpecial(nums, false);
    }

    private static ListNode buildSpecial(int[] nums, boolean hasHead) {
        ListNode res = new ListNode();
        if (nums.length == 0) {
            return res;
        }
        ListNode index = res;
        if (hasHead) {
            index = res.next = new ListNode();
        }
        index.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            index = index.next = new ListNode();
            index.val = nums[i];
        }
        return res;
    }

    public static ListNode buildCycleList(int[] nums, boolean hasHead, int pos) {
        ListNode listNode = buildSpecial(nums, hasHead);
        ListNode index = listNode;
        ListNode cycle = null;
        int num = 0;
        while (index.next != null) {
            if (num == pos) {
                cycle = index;
            }
            index = index.next;
            ++num;
        }
        if (cycle != null) {
            index.next = cycle;
        }
        return listNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<ListNode> set = new HashSet<>();
        ListNode index = this;
        sb.append("[");
        while (index != null && !set.contains(index)) {
            set.add(index);
            sb.append(index.val);
            sb.append(",");
            index = index.next;
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1) + "]";
    }
}
