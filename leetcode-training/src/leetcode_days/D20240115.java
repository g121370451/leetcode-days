package leetcode_days;

import leetcode_days.data_struct.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 *82. 删除排序链表中的重复元素 II
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class D20240115 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode result = new ListNode();
        ListNode index = result;
        ListNode next = head.next;
        while (true) {
            if (next == null){
                index.next = head;
                return result.next;
            }
            if (next.val == head.val){
                while (next.val == head.val) {
                    next = next.next;
                    if (next == null){
                        return result.next;
                    }
                }
                head = next;
            } else {
                index.next = head;
                index = index.next;
                head = head.next;
                index.next = null;
            }
            next = head.next;
        }
    }

    public static void main(String[] args) {
        D20240115 d = new D20240115();
        ListNode listNode = d.deleteDuplicates(ListNode.buildTest3());
        System.out.println(listNode);
    }
}
