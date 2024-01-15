package leetcode_days.data_struct;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

    @Override
    public String toString() {
        if (next == null) {
            return String.valueOf(val);
        }
        return val + "->" + next;
    }
}
