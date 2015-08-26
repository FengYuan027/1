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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        if (root.val % 2 == 0) {
            return recur(root);
        } else {
            return iter(root);
        }
    }
    
    public int recur(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        if (node.left != null && node.right != null) {
            int left = recur(node.left);
            int right = recur(node.right);
            return left < right? left + 1 : right + 1;
        } else if (node.left == null) {
            return recur(node.right) + 1;
        } else {
            return recur(node.left) + 1;
        }
        
        
    }
    
    public int iter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(node);
        int len = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = q.poll();
                if (tempNode.left == null && tempNode.right == null) {
                    return len;
                }
                
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    q.add(tempNode.right);
                }
            }
            len++;
        }
        
        return -1;
    }
}

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                char d = str.charAt(j);
                if (c == d) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        String sss = new String(ss);
        String ttt = new String(tt);
        return sss.equals(ttt);
    }
};
