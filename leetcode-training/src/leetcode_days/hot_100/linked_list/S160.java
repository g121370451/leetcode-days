package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

//160. 相交链表
public class S160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode indexA = headA;
        ListNode indexB = headB;
        while (indexA != null && indexB != null) {
            indexA = indexA.next;
            indexB = indexB.next;
        }
        while (indexA != null) {
            indexA = indexA.next;
            headA = headA.next;
        }
        while (indexB != null) {
            indexB = indexB.next;
            headB = headB.next;
        }
        indexA = headA;
        while (headA != null && headB != null) {
            if (headA != headB) {
                indexA = headA.next;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return indexA;
    }

    public static void main(String[] args) {
        S160 s160 = new S160();
        int[] A = {4, 1, 8, 4, 5};
        int[] B = {5, 6, 1, 8, 4, 5};
        ListNode listNodeA = ListNode.buildSpecialWithoutHead(A);
        ListNode listNodeB = ListNode.buildSpecialWithoutHead(B);
        ListNode intersectionNode = s160.getIntersectionNode(listNodeA, listNodeB);
        System.out.println(intersectionNode);
    }
}
