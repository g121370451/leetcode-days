package leetcode_days.hot_100.linked_list;


import java.util.HashMap;

//138. 随机链表的复制
public class S138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node res = new Node(head.val);
        res.random = head.random;
        Node temp = res;
        map.put(head, res);
        head = head.next;
        while (head != null) {
            Node node = new Node(head.val);
            node.random = head.random;
            map.put(head, node);
            temp = temp.next = node;
            head = head.next;
        }
        temp = res;
        while (temp != null) {
            if (map.containsKey(temp.random)) {
                temp.random = map.get(temp.random);
            }
            temp = temp.next;
        }
        return res;
    }
}