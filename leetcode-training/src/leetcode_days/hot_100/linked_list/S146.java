package leetcode_days.hot_100.linked_list;


import java.util.HashMap;

//146. LRU 缓存
public class S146 {
    public static class LRUCache {
        class ListNodeLRU {
            int key;
            int val;
            ListNodeLRU pre;
            ListNodeLRU next;

            public ListNodeLRU(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private final HashMap<Integer, ListNodeLRU> map;
        private int curCapacity;

        private final int capacity;

        private ListNodeLRU first;
        private ListNodeLRU end;

        public LRUCache(int capacity) {
            this.map = new HashMap<>(capacity);
            this.curCapacity = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                ListNodeLRU listNodeLRU = map.get(key);
                removeListNodeLRU(listNodeLRU);
                addFirst(listNodeLRU);
                return listNodeLRU.val;
            }
            return -1;
        }

        private void removeListNodeLRU(ListNodeLRU listNodeLRU) {
            if (first == listNodeLRU) {
                first = listNodeLRU.next;
            }
            if (end == listNodeLRU) {
                end = listNodeLRU.pre;
            }
            if (listNodeLRU.pre != null) {
                listNodeLRU.pre.next = listNodeLRU.next;
            }
            if (listNodeLRU.next != null) {
                listNodeLRU.next.pre = listNodeLRU.pre;
            }
            listNodeLRU.next = null;
            listNodeLRU.pre = null;
        }

        private void addFirst(ListNodeLRU listNodeLRU) {
            if (this.first == null) {
                this.first = listNodeLRU;
                this.end = listNodeLRU;
                return;
            }
            this.first.pre = listNodeLRU;
            listNodeLRU.next = first;
            first = listNodeLRU;
        }

        public void put(int key, int value) {
            ListNodeLRU listNodeLRU;
            if (map.containsKey(key)) {
                listNodeLRU = map.get(key);
                listNodeLRU.val = value;
                removeListNodeLRU(listNodeLRU);
                addFirst(listNodeLRU);
            } else {
                if (this.curCapacity == this.capacity) {
                    listNodeLRU = this.end;
                    this.map.remove(listNodeLRU.key);
                    listNodeLRU.key = key;
                    listNodeLRU.val = value;
                    removeListNodeLRU(listNodeLRU);
                    addFirst(listNodeLRU);
                } else {
                    listNodeLRU = new ListNodeLRU(key, value);
                    addFirst(listNodeLRU);
                    this.curCapacity++;
                }
            }
            map.put(key, listNodeLRU);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
