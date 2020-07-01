package leetcode._100_150._133;

import leetcode.common.Node;

import java.util.*;

/*
133. Clone Graph
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


Test case format:

For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.

Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */
public class LC_133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        queue.offer(node);
        map.put(node, null);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            for (Node next : cur.neighbors) {
                if (!map.containsKey(next)) {
                    queue.offer(next);
                    map.put(next, null);
                }
            }
        }

        for (Node ori : map.keySet()) {
            Node cpy = map.get(ori);
            for (Node nei : ori.neighbors) {
                cpy.neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}
