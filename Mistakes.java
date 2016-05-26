public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] maxLength = new int[1];
        helper(root, maxLength);
        return maxLength[0];
    }
    
    private int helper(TreeNode root, int[] maxLength) {
        if (root == null) return 0;
        int currentLength = 1;
        // Problem begin
        if (root.left != null && root.left.val - 1 == root.val) currentLength += helper(root.left, maxLength);
        if (root.right != null && root.right.val - 1 == root.val) currentLength = Math.max(currentLength, 1 + helper(root.right, maxLength));
        // Problem end
        maxLength[0] = Math.max(maxLength[0], currentLength);
        return currentLength;
    }
}

// Flip Game II
public class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }
    
    private boolean canWin(char[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == '+' && s[i+1] == '+') {
                s[i] = s[i+1] = '-';
                // Begin
                if (!canWin(s)) return true;
                s[i] = s[i + 1] = '+';
                // End
            }
        }
        return false;
    }
}
