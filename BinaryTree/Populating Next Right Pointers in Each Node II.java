/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode nextLevel = null, prev = null;
            while (root != null) {
                if (root.left != null) {
                    if (prev == null) {
                        nextLevel = root.left;
                        prev = root.left;
                    }
                    else {
                        prev.next = root.left;
                        prev = root.left;
                    }
                }
                if (root.right != null) {
                    if (prev == null) {
                        nextLevel = root.right;
                        prev = root.right;
                    }
                    else {
                        prev.next = root.right;
                        prev = root.right;
                    }
                }
                root = root.next;
            }
            root = nextLevel;
        }
    }
}
