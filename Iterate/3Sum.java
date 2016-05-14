/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[start], nums[end]));
                }
                if (sum <= 0) {
                    start++;
                    while (start < end && nums[start] == nums[start-1]) start++;
                }
                if (sum >= 0) {
                    end--;
                    while (start < end && nums[end] == nums[end+1]) end--;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i+1]) i++;
        }
        return triplets;
    }
}
