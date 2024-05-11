package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

// 142. 环形链表 II
// 3 2 0 4
public class S142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode ptr = head;
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
            slow = slow.next;
            if (fast != null && fast == slow) {
                while (slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        S142 s142 = new S142();
        int[] heads = {3, 2, 0, -4};
        ListNode listNode = ListNode.buildCycleList(heads, false, 1);
        System.out.println(s142.detectCycle(listNode));
    }
}
