package leetcode_days.hot_100.linked_list;

import leetcode_days.data_struct.ListNode;


//19. 删除链表的倒数第 N 个结点
public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode headRes = new ListNode(0, head);
        ListNode index = head;
        ListNode res = headRes;
        while (n > 0) {
            head = head.next;
            --n;
        }
        while (head != null) {
            head = head.next;
            index = index.next;
            headRes = headRes.next;
        }
        headRes.next = index.next;
        return res.next;
    }

    public static void main(String[] args) {
        S19 s19 = new S19();
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode listNode = ListNode.buildSpecialWithoutHead(nums);
        System.out.println(s19.removeNthFromEnd(listNode, n)); //[1,2,3,5][]
    }
}
