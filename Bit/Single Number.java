/*
Given an array of integers, every element appears twice except for one. Find that single one.
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums) mask ^= num;
        return mask;
    }
}
