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
