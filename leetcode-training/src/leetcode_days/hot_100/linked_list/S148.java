package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

import java.util.ArrayDeque;
import java.util.Objects;

//148. 排序链表
public class S148 {
    public ListNode sortList(ListNode head) {
        if (head==null){
            return head;
        }
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode res_temp;
        while (head != null) {
            deque.addFirst(head);
            res_temp = head.next;
            head.next = null;
            head = res_temp;
        }
        res_temp = new ListNode();
        while (deque.size() != 1) {
            int k = deque.size();
            while (k > 1) {
                k -= 2;
                ListNode pre = deque.pollLast();
                ListNode after = deque.pollLast();
                ListNode temp = res_temp;
                while (pre != null && after != null) {
                    if (pre.val <= after.val) {
                        temp = temp.next = pre;
                        pre = pre.next;
                    } else {
                        temp = temp.next = after;
                        after = after.next;
                    }
                }
                while(pre!=null){
                    temp = temp.next = pre;
                    pre = pre.next;
                }
                while(after!=null){
                    temp = temp.next = after;
                    after = after.next;
                }
                deque.addFirst(res_temp.next);
            }
            if (k == 1) {
                deque.addFirst(deque.pollLast());
            }
        }
        return deque.pollLast();
    }

    public static void main(String[] args) {
        S148 s148 = new S148();
        int[] nums = {4, 2, 1, 3};
        int[] nums2 = {2, 1, 3, 4};
        ListNode listNode = ListNode.buildSpecialWithoutHead(nums);
        System.out.println(s148.sortList(listNode));
    }
}
