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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode next = cur.next;
            pre = helper;
            while(pre.next!=null && pre.next.val<=cur.val)
            {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head = new ListNode(0);
        ListNode node = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            node.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            node = node.next;
            l1 = l1.next; l2 = l2.next;
            
        }
        
        if(l1 != null){
            while(l1 != null){
                node.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
                node = node.next;
            }
        }
        
        if(l2 != null){
            while(l2 != null){
                node.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
                node = node.next;
            }
        }
        
        
        if(carry != 0) node.next = new ListNode(carry);
        return head.next;
    }
}

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() < 0) {
            return rst;
        }
        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, rst);
        return rst;
    }
    //Check Palindrome
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //helper:
    public void helper(String s, ArrayList<String> path, int pos, 
        List<List<String>> rst) {
        if (pos == s.length()) {
            rst.add(new ArrayList<String>(path));
            return;
        }        
        for (int i = pos + 1; i <= s.length(); i++) {//i is used in s.sbustring(pos, i), which can equal to s.length()
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(prefix);
            helper(s, path, i, rst);
            path.remove(path.size() - 1);
        }    
    }
}
