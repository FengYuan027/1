/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(permutations, new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return permutations;
    }
    
    private void backtrack(List<List<Integer>> permutations, LinkedList<Integer> permutation, int[] nums, boolean[] visited) {
        if (permutation.size() == nums.length) {
            permutations.add(new LinkedList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && (i == 0 || nums[i] != nums[i-1] || visited[i-1])) {
                visited[i] = true;
                permutation.add(nums[i]);
                backtrack(permutations, permutation, nums, visited);
                permutation.removeLast();
                visited[i] = false;
            }
        }
    }
}
