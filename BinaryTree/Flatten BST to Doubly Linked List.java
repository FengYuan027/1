
class Solution {
  
  private TreeNode prev = null;
  
  public TreeNode flatten (TreeNode root) {
        if (node == null) return null;
        flatten(root.right);
        TreeNode left = root.left;
        root.right = prev;
        if (prev != null) {
              prev.left = root;
        }
        root.left = null;
        prev = root;
        if (left != null) return flatten(left);
        return root;
  }
}
