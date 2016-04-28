public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return new ArrayList<List<Integer>>();
        int N = nums.length, M = (int) Math.pow(2, N);
        Arrays.sort(nums);
        ArrayList<List<Integer>> subsets = new ArrayList<List<Integer>>();
        for (int i = 0; i < M; i++) subsets.add(new ArrayList<Integer>());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (((j>>i)&1)!= 0) subsets.get(j).add(nums[i]);
            }
        }
        return subsets;
    }
}

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        if (nums == null) return subsets;
        Arrays.sort(nums);
        dfs(subsets, nums, 0, new LinkedList<Integer>());
        return subsets;
    }
    
    private void dfs(List<List<Integer>> subsets, int[] nums, int index, LinkedList<Integer> subset) {
        if (index == nums.length) {
            subsets.add(new LinkedList<Integer>(subset));
            return;
        }
        dfs(subsets, nums, index+1, subset);
        subset.addLast(nums[index]);
        dfs(subsets, nums, index+1, subset);
        subset.removeLast();
    }
}

public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        dfs(subsets, new LinkedList<Integer>(), nums, 0);
        return subsets;
    }
    
    private void dfs(List<List<Integer>> subsets, LinkedList<Integer> subset, int[] nums, int index) {
        subsets.add(new LinkedList<Integer>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.addLast(nums[i]);
            dfs(subsets, subset, nums, i+1);
            subset.removeLast();
        }
    }
}
