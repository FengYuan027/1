/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return sets;
        }
        HashSet<Integer> visited = new HashSet<Integer>();
        for (UndirectedGraphNode node: nodes) {
            if (!visited.contains(node.label)) {
                List<Integer> set = new ArrayList<Integer>();
                visit(node, visited, set);
                Collections.sort(set);
                sets.add(set);
            }
        }
        return sets;
    }
    
    private void visit(UndirectedGraphNode node, HashSet<Integer> visited, List<Integer> set) {
        visited.add(node.label);
        set.add(node.label);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (!visited.contains(neighbor.label)) {
                visit(neighbor, visited, set);
            }
        }
    }
}
