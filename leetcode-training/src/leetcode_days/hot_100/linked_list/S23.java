package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

import java.util.ArrayDeque;
import java.util.Objects;

public class S23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        for (ListNode list : lists) {
            if (list != null && list.val != null) {
                deque.addFirst(list);
            }
        }
        if (deque.isEmpty()){
            return null;
        }
        ListNode res_temp = new ListNode();
        ListNode temp;
        while (deque.size() != 1) {
            int k = deque.size();
            while (k > 1) {
                k -= 2;
                ListNode pre = deque.pollLast();
                ListNode after = deque.pollLast();
                temp = res_temp;
                while (pre != null && after != null) {
                    if (pre.val <= after.val) {
                        temp = temp.next = pre;
                        pre = pre.next;
                        temp.next = null;
                    } else {
                        temp = temp.next = after;
                        after = after.next;
                        temp.next = null;
                    }
                }
                if (pre != null) {
                    temp.next = pre;
                } else if (after != null) {
                    temp.next = after;
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
        S23 s23 = new S23();
        int[][] nums1 = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        int[][] nums = {{}, {}, {}};
        ListNode[] list = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = ListNode.buildSpecialWithoutHead(nums[i]);
        }
        System.out.println(s23.mergeKLists(list));
    }
}
