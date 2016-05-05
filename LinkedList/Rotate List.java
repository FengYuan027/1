/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 || (k%=getLength(head)) == 0) return head;
        ListNode start = head, end = head;
        while (k-- > 0) end = end.next;
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        ListNode reversed = start.next;
        start.next = null;
        end.next = head;
        return reversed;
    }
    
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}

public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if ((k%=length) > 0) {
            tail.next = head;
            for (int i = 0; i < length - k; i++) {
                tail = tail.next;
            }
            head = tail.next;
            tail.next = null;
        }
        return head;
    }
}
