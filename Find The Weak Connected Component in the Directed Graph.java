/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) return components;
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for (DirectedGraphNode root: nodes) {
            int parent = map.containsKey(root.label)? findRoot(map, root.label) : root.label;
            ArrayList<Integer> parents = new ArrayList<Integer>();
            parents.add(parent);
            for (DirectedGraphNode neighbor: root.neighbors) {
                if (map.containsKey(neighbor.label)) {
                    int prev_parent = findRoot(map, neighbor.label);
                    parents.add(prev_parent);
                    parent = Math.min(parent, prev_parent);
                }
            }
            for (DirectedGraphNode neighbor: root.neighbors) {
                map.put(neighbor.label, parent);
            }
            for (Integer p: parents) {
                map.put(p, parent);
            }
            map.put(root.label, parent);
        }
        Hashtable<Integer, ArrayList<Integer>> componentMap = new Hashtable<Integer, ArrayList<Integer>>();
        for (Integer key: map.keySet()) {
            int root = findRoot(map, key);
            if (!componentMap.containsKey(root)) {
                componentMap.put(root, new ArrayList<Integer>());
            }
            componentMap.get(root).add(key);
        }
        for (ArrayList<Integer> component: componentMap.values()) {
            Collections.sort(component);
            components.add(component);
        }
        return components;
    }
    
    public int findRoot(Hashtable<Integer, Integer> map, int tag) {
        while (map.get(tag) != tag) {
            tag = map.get(tag);
        }
        return tag;
    }
}
