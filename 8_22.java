/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int base = 0;
        for (int i = 0; i <= expression.length; i++) {
            if (i < expression.length) {
                if(expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                else if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
            }
            TreeNode right = i == expression.length ?
                new TreeNode(Integer.MIN_VALUE, "") : new TreeNode(getValue(expression[i], base), expression[i]);
            while (!stack.isEmpty()) {
                if (right.val <= stack.peek().val) {
                    TreeNode curr = stack.pop();
                    if (stack.isEmpty()) {
                        right.root.left = curr.root;
                    }
                    else {
                        TreeNode left = stack.peek();
                        if (left.val < right.val) {
                            right.root.left = curr.root;
                        }
                        else {
                            left.root.right = curr.root;
                        }
                    }
                }
                else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
    }
    
    int getValue(String s, int base) {
        if (s.equals("+") || s.equals("-")) {
            return 1 + base;
        }
        else if (s.equals("*") || s.equals("/")) {
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    }
    
    public class TreeNode {
        int val;
        ExpressionTreeNode root;
        public TreeNode(int val, String s) {
            this.val = val;
            this.root = new ExpressionTreeNode(s);
        }
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode last = head;
        while (n-- > 0) {
            last = last.next;
        }
        while (last != null) {
            head = head.next;
            last = last.next;
        }
        return head;
    }
}
