public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            String temp = new String(strs[j]);
            strs[j] = new String(strs[i]);
            strs[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() > 0) {
                sb.append(strs[i]);
                if (i < strs.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dummyPre = new ListNode(0);
        ListNode dummyPost = new ListNode(0);
        ListNode pre = dummyPre;
        ListNode post = dummyPost;

        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                post.next = head;
                post = post.next;
            }
             head = head.next;
        }
        
        post.next = null;
        pre.next = dummyPost.next;
        
        return dummyPre.next;
    }
}
