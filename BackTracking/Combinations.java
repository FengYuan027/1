public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) return combinations;
        dfs(combinations, new int[k], 1, n, 0);
        return combinations;
    }
    
    public void dfs(List<List<Integer>> combinations, int[] combination, int start, int n, int index) {
        if (index == combination.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int num : combination) list.add(num);
            combinations.add(list);
            return;
        }
        for (int i = start; i <= n; i++) {
            combination[index] = i;
            dfs(combinations, combination, i + 1, n, index+1);
        }
    }
}
