public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            for (List<Integer> prev : subsets) {
                List<Integer> subset = new ArrayList<Integer>(prev);
                subset.add(nums[i]);
                current.add(subset);
            }
            subsets.addAll(current);
            while (i + 1 < nums.length && nums[i] == nums[i+1]) {
                List<List<Integer>> next = new ArrayList<List<Integer>>();
                for (List<Integer> prev : current) {
                    List<Integer> subset = new ArrayList<Integer>(prev);
                    subset.add(nums[i]);
                    next.add(subset);
                }
                subsets.addAll(next);
                current = next;
                i++;
            }
        }
        return subsets;
    }
}
