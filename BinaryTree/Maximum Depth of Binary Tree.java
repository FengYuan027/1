/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int depth = 0;
        q.add(root);
        while (!q.isEmpty()) {
            depth++;
            Queue<TreeNode> next = new LinkedList<TreeNode>();
            while (!q.isEmpty()) {
                root = q.poll();
                if (root.left != null) next.add(root.left);
                if (root.right != null) next.add(root.right);
            }
            q = next;
        }
        return depth;
    }
}
