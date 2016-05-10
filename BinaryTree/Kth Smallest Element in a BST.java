/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] counter = {k};
        return kthSmallest(root, counter).val;
    }
    
    private TreeNode kthSmallest(TreeNode root, int[] counter) {
        if (root == null) return null;
        TreeNode left = kthSmallest(root.left, counter);
        if (left == null) {
            if (--counter[0] == 0) return root;
            return kthSmallest(root.right, counter);
        }
        return left;
    }
}
