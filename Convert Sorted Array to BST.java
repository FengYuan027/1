/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null) {
            return null;
        }
        return convert(A, 0, A.length - 1);
    }
    
    private TreeNode convert(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = convert(A, start, mid - 1);
        root.right = convert(A, mid + 1, end);
        return root;
    }
}
