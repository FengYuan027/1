/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

public class Solution1 {
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

public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countNode(root.left);
        if (leftCount >= k) return kthSmallest(root.left, k);
        else if (leftCount == k - 1) return root.val;
        else return kthSmallest(root.right, k - leftCount - 1);
    }
    
    public int countNode(TreeNode root) {
        if (root == null) return 0;
        return countNode(root.left) + countNode(root.right) + 1;
    }
}

public class Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        do {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k > 0) root = root.right;
        } while (k > 0);
        return root.val;
    }
}
