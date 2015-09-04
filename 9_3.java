public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		if (n < 1 || k < 1 || k > n) {
		    return combs;
		}
		ArrayList<Integer> comb = new ArrayList<Integer>();
		generate(1, n, k, combs, comb);
		return combs;
    }
    
    private void generate(int start, int end, int k, List<List<Integer>> combs, ArrayList<Integer> comb) {
        if (k == 0) {
            List<Integer> copy = new ArrayList<Integer>(comb);
            combs.add(copy);
            return;
        }
        for (int i = start; i <= end; i++) {
            comb.add(i);
            generate(i + 1, end, k - 1, combs, comb);
            comb.remove(comb.size() - 1);
        }
    }
}

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if (n <= 0) {
            return 1;
        }
        int[] trees = new int[n+1];
        trees[0] = 1;
        return numTrees(n, trees);
    }
    
    public int numTrees(int n, int[] trees) {
        if (n <= 0) {
            return 1;
        }
        if (trees[n] > 0) {
            return trees[n];
        }
        for (int i = 1; i <= n; i++) {
            trees[n] += numTrees(i-1, trees) * numTrees(n - i, trees);
        }
        return trees[n];
    }
}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChildren = generate(start, i - 1);
            for (int j = 0; j < leftChildren.size(); j++) {
                List<TreeNode> rightChildren = generate(i+1, end);
                for (int k = 0; k < rightChildren.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChildren.get(j);
                    root.right = rightChildren.get(k);
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
