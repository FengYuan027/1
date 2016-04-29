public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] needs = new int[256];
        for (char c : t.toCharArray()) needs[c]++;
        int[] counter = new int[256];
        int count = 0, minLength = Integer.MAX_VALUE, minStart = -1;
        char str[] = s.toCharArray();
        for (int start = 0, end = 0; end < str.length; end++) {
            counter[str[end]]++;
            if (counter[str[end]] <= needs[str[end]]) count++;
            while (start < end && counter[str[start]] - 1 >= needs[str[start]]){
                counter[str[start++]]--;
            }
            if (count == t.length() && end - start + 1 < minLength) {
                minLength = end - start + 1;
                minStart = start;
            }
        }
        if (minStart >= 0) return s.substring(minStart, minStart + minLength);
        return "";
    }
}
