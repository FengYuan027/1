public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> cache = new HashSet<Character>();
        int left = 0, right = 0, N = s.length();
        int max_length = 0;
        while (right < N) {
            char c = s.charAt(right);
            while (cache.contains(c)) {
                cache.remove(s.charAt(left++));
            }
            cache.add(c);
            max_length = Math.max(max_length, right - left + 1);
            right++;
        }
        return max_length;
    }
}
