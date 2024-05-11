package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

//141. 环形链表
// 快慢指针
public class S141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
            slow = slow.next;
            if (fast != null && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S141 s141 = new S141();
        int[] heads = {3, 2, 0, -4};
        ListNode listNode = ListNode.buildCycleList(heads, false, 1);
        System.out.println(s141.hasCycle(listNode));
    }
}
