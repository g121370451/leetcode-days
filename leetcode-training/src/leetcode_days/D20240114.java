package leetcode_days;

import leetcode_days.data_struct.ListNode;

public class D20240114 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val == head.val) {
                if (next.next == null) {
                    head.next = null;
            } else {
                    head.next = next.next;
                }
            } else {
                head = next;
            }
            next = head.next;
        }
        return index;
    }

    public static void main(String[] args) {
        D20240114 d = new D20240114();
        ListNode listNode = d.deleteDuplicates(ListNode.buildTest2());
        System.out.println(listNode);
    }
}
