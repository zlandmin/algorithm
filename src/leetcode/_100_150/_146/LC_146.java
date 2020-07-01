package leetcode._100_150._146;

import java.util.HashMap;
import java.util.Map;

/*
146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */
public class LC_146 {
    private class Node {
        int key;
        int value;
        LC_146.Node prev;
        LC_146.Node next;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
        Node() {
            this.key = 0;
            this.value = 0;
        }
    }

    private int capacity;
    private int count;
    private Node head;
    private Node tail;
    private Map<Integer, LC_146.Node> map;

    public LC_146(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();
        head = new LC_146.Node();
        tail = new LC_146.Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LC_146.Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            remove(node);
            add(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        LC_146.Node node = map.get(key);
        if (node == null) {
            node = new LC_146.Node(key, value);
            map.put(key, node);
            add(node);
            count++;
            if (count > capacity) {
                LC_146.Node toDelete = tail.prev;
                map.remove(toDelete.key);
                remove(toDelete);
                count--;
            }
        } else {
            remove(node);
            node.value = value;
            add(node);
        }
    }

    private void remove(LC_146.Node node) {
        LC_146.Node next = node.next;
        LC_146.Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void add(LC_146.Node node) {
        LC_146.Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
}
