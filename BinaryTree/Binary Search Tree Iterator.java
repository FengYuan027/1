/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

public class BSTIterator {
    
    private Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        pushToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            int val = s.peek().val;
            pushToStack(s.pop().right);
            return val;
        }
        return Integer.MIN_VALUE;
    }
    
    private void pushToStack(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }
}
