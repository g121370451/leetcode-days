package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

import java.util.ArrayDeque;

//25. K 个一组翻转链表
public class S25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode first = res;
        ArrayDeque<ListNode> list = new ArrayDeque<>();
        while (head != null) {
            while (list.size() < k && head != null) {
                list.addFirst(head);
                head = head.next;
            }
            if (list.size() == k) {
                while (!list.isEmpty()) {
                    first = first.next = list.pollFirst();
                }
            }
        }
        while (!list.isEmpty()) {
            first = first.next = list.pollLast();
        }
        first.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        S25 s25 = new S25();
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {1, 2};
        System.out.println(s25.reverseKGroup(ListNode.buildSpecialWithoutHead(nums), 2));
    }
}
