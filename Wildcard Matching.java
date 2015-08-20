public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }
        if (p.equals("")) {
            return s.equals("");
        }
        int last_s = -1, last_p = -1, index_s = 0, index_p = 0;
        while (index_s < s.length() && index_p < p.length()) {
            while (index_p < p.length() && p.charAt(index_p) == '*') {
                last_s = index_s;
                last_p = index_p++;
            }
            if (index_p == p.length()) {
                return true;
            }
            if (s.charAt(index_s) == p.charAt(index_p) || p.charAt(index_p) == '?') {
                index_s++;
                index_p++;
            }
            else if (last_p >= 0) {
                index_s = ++last_s;
                index_p = last_p + 1;
            }
            else {
                return false;
            }
        }
        while (index_p < p.length() && p.charAt(index_p) == '*') {
            index_p++;
        }
        return index_s == s.length() && index_p == p.length();
     }
}
