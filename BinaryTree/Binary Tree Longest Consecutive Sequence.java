/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/

public class Solution {
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxLength;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftLength = helper(root.left), rightLength = helper(root.right), currentLength = 1;
        if (root.left != null && root.left.val == root.val + 1) currentLength += leftLength;
        if (root.right != null && root.right.val == root.val + 1) currentLength = Math.max(currentLength, rightLength + 1);
        maxLength = Math.max(maxLength, currentLength);
        return currentLength;
    }
}
