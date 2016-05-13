/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode dummy = new ListNode(0), current = dummy;
        dummy.next = head;
        while (current != null && current.next != null) {
            int count = 0;
            ListNode end = current.next;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (count < k) return dummy.next;
            ListNode tail = current.next;
            current.next = reverse(current.next, end);
            tail.next = end;
            current = tail;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head, ListNode end) {
        ListNode newHead = null;
        while (head != end) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
