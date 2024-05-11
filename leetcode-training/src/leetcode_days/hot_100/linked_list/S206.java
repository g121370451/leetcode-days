package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;

// 260.反转链表
public class S206 {
    // 比较恶心的是 他没有头结点 我可以做一个 然后返回next
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode node = new ListNode();
        ListNode index;
        while (head != null) {
            index = head.next;
            head.next = node.next;
            node.next = head;
            head = index;
        }
        return node.next;
    }

    public static void main(String[] args) {
        S206 s206 = new S206();
        int[] heads = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.buildSpecialWithoutHead(heads);
        System.out.println(s206.reverseList(listNode));
    }
}
