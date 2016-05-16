/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        int maxLength = 0;
        for (int num : nums) {
            int forward = num, backward = num - 1, length = 0;
            while (set.contains(forward)) {
                length++;
                set.remove(forward++);
            }
            while (set.contains(backward)) {
                length++;
                set.remove(backward--);
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
