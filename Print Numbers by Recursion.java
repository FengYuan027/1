public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> nums = new ArrayList<Integer>();
        if (n <= 0) {
            return nums;
        }
        if (n == 1) {
            for (int i = 1; i < 10; i++) {
                nums.add(i);
            }
            return nums;
        }
        List<Integer> prev = numbersByRecursion(n-1);
        nums.addAll(prev);
        int pivot = (int) Math.pow(10, n-1);
        for (int i = 1; i < 10; i++) {
            int base = i * pivot;
            nums.add(base);
            for (int j = 0; j < prev.size(); j++) {
                nums.add(base + prev.get(j));
            }
        }
        return nums;
    }
}
