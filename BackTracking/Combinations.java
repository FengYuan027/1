public class Solution1 {
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

public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }
}

public class Solution3 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) return combinations;
        int[] combination = new int[k];
        int index = 0;
        while (index >= 0) {
            combination[index]++;
            if (combination[index] > n) {
                index--;
            }
            else {
                if (index == k - 1) {
                    List<Integer> list = new ArrayList<Integer>();
                    for (int num : combination) list.add(num);
                    combinations.add(list);
                }
                else {
                    index++;
                    combination[index] = combination[index-1];
                }
            }
        }
        return combinations;
    }
}
