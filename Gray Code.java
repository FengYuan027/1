public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> code = new ArrayList<Integer>();
        if (n < 0) {
            return code;
        }
        if (n == 0) {
            code.add(0);
            return code;
        }
        ArrayList<Integer> prev = grayCode(n-1);
        code.addAll(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            code.add((1<<(n-1)) + prev.get(i));
        }
        return code;
    }
}
