public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> indice = new ArrayList<Integer>();
        if (nums == null || nums.length < 1) return indice;
        int accumulate = 0;
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            accumulate += nums[i];
            if (map.containsKey(accumulate)) {
                indice.add(map.get(accumulate)+1);
                indice.add(i);
                return indice;
            }
            else map.put(accumulate, i);
        }
        return indice;
    }
}
