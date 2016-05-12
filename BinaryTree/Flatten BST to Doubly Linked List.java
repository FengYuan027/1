
class Solution1 {
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

class Solution2 {
    private TreeNode prev = null;
    private TreeNode head = null;
    
    public TreeNode flatten(TreeNode root) {
        if (root == null) return;
        TreeNode leftHead = flatten(root.left);
        if (prev != null) {
            prev.right = root;
            root.left = prev;
        }
        else {
            head = root;
        }
        prev = root;
        flatten(root.right);
        return leftHead == null ? root : leftHead;
    }
}
