public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        while (l1 != null) {
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }
        return head.next;
    }
}
