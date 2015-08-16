public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }
        HashMap<Character, Integer> cache = new HashMap<Character, Integer>();
        int left = 0, right = 0, N = s.length();
        int count = 0, max_length = 0;
        while (right < N) {
            char c = s.charAt(right);
            if (cache.containsKey(c) && cache.get(c) > 0) {
                cache.put(c, cache.get(c) + 1);
            }
            else {
                cache.put(c, 1);
                count++;
            }
            while (count > k) {
                char t = s.charAt(left++);
                cache.put(t, cache.get(t) - 1);
                if (cache.get(t) == 0) {
                    count--;
                }
            }
            max_length = Math.max(max_length, right - left + 1);
            right++;
        }
        return max_length;
    }
}
