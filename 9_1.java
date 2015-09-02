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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (fast.val == slow.val) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return nums == null ? 0 : nums.length;
        }
        int curr = -1, index = 0;
        while (index < nums.length) {
            nums[++curr] = nums[index++];
            int count = 1;
            while (index < nums.length && nums[index] == nums[index-1]) {
                index++;
                count++;
            }
            count = Math.min(count, 2);
            while (count > 1) {
                nums[++curr] = nums[curr-1];
                count--;
            }
        }
        return curr+1;
    }
}

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}

