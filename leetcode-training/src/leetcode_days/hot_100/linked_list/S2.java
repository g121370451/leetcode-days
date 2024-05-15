package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

import java.util.List;

public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode preNode = l1;
        int sum;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int target = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + pre;
            l1.val = sum % 10;
            l2.val = l1.val;
            pre = sum / 10;
            preNode = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            preNode = l1;
            sum = l1.val + pre;
            l1.val = sum % 10;
            pre = sum / 10;
            l1 = l1.next;
        } else if (l2 != null) {
            target = 1;
            preNode = l2;
            sum = l2.val + pre;
            l2.val = sum % 10;
            pre = sum / 10;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + pre;
            l1.val = sum % 10;
            pre = sum / 10;
            preNode = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + pre;
            l2.val = sum % 10;
            pre = sum / 10;
            preNode = l2;
            l2 = l2.next;
        }
        if (pre == 1) {
            preNode.next = new ListNode(1);
        }
        if (target == 0) {
            return t1;
        }
        return t2;
    }

    public static void main(String[] args) {
        S2 s2 = new S2();
//        int[] nums1 = {2, 4, 3};
//        int[] nums2 = {5, 6, 4};//708
        int[] nums1 = {9,9,9,9,9,9,9};
        int[] nums2 = {9,9,9,9};//8,9,9,9,0,0,0,1
        ListNode listNode1 = ListNode.buildSpecialWithoutHead(nums1);
        ListNode listNode2 = ListNode.buildSpecialWithoutHead(nums2);
        ListNode listNode = s2.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }
}
