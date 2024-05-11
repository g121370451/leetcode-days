package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

import java.util.List;

// 234.回文链表
// 1 2 3 2 1
// 1 2 3 4 2 1
public class S234 {
    public ListNode reverseList(ListNode node) {
        ListNode head = new ListNode();
        ListNode index;
        while (node != null) {
            index = node.next;
            node.next = head.next;
            head.next = node;
            node = index;
        }
        return head.next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
            slow = slow.next;
        }
        slow = reverseList(slow);
        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        S234 s234 = new S234();
        int[] heads = {1, 2, 2, 1};
        int[] heads1 = {1, 2, 3, 2, 1};
        int[] heads2 = {1, 2, 3, 4, 2, 1};
        System.out.println(s234.isPalindrome(ListNode.buildSpecialWithoutHead(heads)));
        System.out.println(s234.isPalindrome(ListNode.buildSpecialWithoutHead(heads1)));
        System.out.println(s234.isPalindrome(ListNode.buildSpecialWithoutHead(heads2)));
    }
}
