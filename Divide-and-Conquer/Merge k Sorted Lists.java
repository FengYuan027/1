/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        return mergeTwoLists(mergeKLists(lists, start, start + (end-start)/2), mergeKLists(lists, start + (end - start)/2 + 1, end));
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = l1;
            current = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = l2;
            current = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode head : lists) {
            if (head != null) minHeap.add(head);
        }
        ListNode dummy = new ListNode(0), current = dummy;
        while (!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
            if (current.next != null) {
                minHeap.add(current.next);
            }
        }
        return dummy.next;
    }
}
