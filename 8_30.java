/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (graph == null || s == null || t == null) {
            return false;
        }
        if (s.label == t.label) {
            return true;
        }
        LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(s);
        visited.add(s.label);
        while (queue.size() > 0) {
            DirectedGraphNode n = queue.removeFirst();
            for (DirectedGraphNode neighbor: n.neighbors) {
                if (neighbor.label == t.label) {
                    return true;
                }
                if (!visited.contains(neighbor.label)) {
                    visited.add(neighbor.label);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> anagrams = new ArrayList<String>();
        if (strs == null) {
            return anagrams;
        }
        HashMap<String, List<String>> dict = new HashMap<String, List<String>>();
        for (String str: strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            if (!dict.containsKey(key)) {
                dict.put(key, new ArrayList<String>());
            }
            dict.get(key).add(str);
        }
        for (String key: dict.keySet()) {
            if (dict.get(key).size() > 1) {
                anagrams.addAll(dict.get(key));
            }
        }
        return anagrams;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        ListNode node2 = head;
        while (k-- > 0) {
            node2 = node2.next;
        }
        node = head;
        while (node2.next != null) {
            node = node.next;
            node2 = node2.next;
        }
        node2.next = head;
        head = node.next;
        node.next = null;
        return head;
    }
}
