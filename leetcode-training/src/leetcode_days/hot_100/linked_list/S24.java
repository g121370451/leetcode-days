package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

//24. 两两交换链表中的节点
public class S24 {
    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode();
        ListNode res = first;
        ListNode index;
        while (head != null && head.next!=null){
            index = head.next.next;
            first = first.next = head.next;
            first = first.next = head;
            head = index;
        }
        first.next = head;
        return res.next;
    }

    public static void main(String[] args) {
        S24 s24 = new S24();
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {1, 2, 3, 4};
        System.out.println(s24.swapPairs(ListNode.buildSpecialWithoutHead(nums)));
    }
}
