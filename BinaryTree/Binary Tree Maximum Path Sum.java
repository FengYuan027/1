/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

public class Solution1 {
    private int maximumSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maximumSum = Integer.MIN_VALUE;
        helper(root);
        return maximumSum;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftSubSum = helper(root.left), rightSubSum = helper(root.right);
        int currentMax = root.val, leftPartial = root.val, rightPartial = root.val;
        if (leftSubSum > 0) {
            currentMax += leftSubSum;
            leftPartial += leftSubSum;
        }
        if (rightSubSum > 0) {
            currentMax += rightSubSum;
            rightPartial += rightSubSum;
        }
        maximumSum = Math.max(maximumSum, currentMax);
        return Math.max(leftPartial, rightPartial);
    }
}

public class Solution2 {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
