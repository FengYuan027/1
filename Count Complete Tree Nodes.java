/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_h = 0, right_h = 0;
        TreeNode left = root;
        while (left != null) {
            left = left.left;
            left_h++;
        }
        TreeNode right = root;
        while (right != null) {
            right = right.right;
            right_h++;
        }
        if (left_h == right_h){
            return (1 << left_h) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
