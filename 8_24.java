public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int len = A.length;
        if (len == 0) {
        	return len;
        }

        int slow = 0;
        int fast = 0;
        while (fast != len) {
        	if (A[fast] == elem) {
        		fast++;
        	} else {
        		A[slow++] = A[fast++];
        	}
        }

        return slow;
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
        	return node;
        }

        TreeNode runner = root;
        TreeNode parent = null;
        while (runner != null) {
        	parent = runner;
        	if (runner.val < node.val) {
        		runner = runner.right;
        	} else {
        		runner = runner.left;
        	}
        }

        // if (parent != null) {
        	if (parent.val < node.val) {
        		parent.right = node;
        	} else {
        		parent.left = node;
        	}
        // }

        return root;
    }
}
