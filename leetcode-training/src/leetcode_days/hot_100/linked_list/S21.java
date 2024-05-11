package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

//21. 合并两个有序链表
public class S21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1== null || list2 ==null){
            if (list1 == null){
                return list2;
            }
            return list1;
        }
        ListNode res;
        if (list1.val <= list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        ListNode index = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                index.next = list1;
                list1 = list1.next;
            } else {
                index.next = list2;
                list2 = list2.next;
            }
            index = index.next;
        }
        while (list1 != null) {
            index.next = list1;
            list1 = list1.next;
            index = index.next;
        }
        while (list2 != null) {
            index.next = list2;
            list2 = list2.next;
            index = index.next;
        }
        return res;
    }

    public static void main(String[] args) {
        S21 s21 = new S21();
        int[] num1 = {1, 2, 4};
        int[] num2 = {1, 3, 4};
        System.out.println(s21.mergeTwoLists(ListNode.buildSpecialWithoutHead(num1), ListNode.buildSpecialWithoutHead(num2)));
    }
}
