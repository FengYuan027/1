public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int N = s.length();
        HashMap<Character, Character> s_map = new HashMap<Character, Character>();
        HashMap<Character, Character> t_map = new HashMap<Character, Character>();
        for (int i = 0; i < N; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (!s_map.containsKey(c1) && !t_map.containsKey(c2)) {
                s_map.put(c1, c2);
                t_map.put(c2, c1);
            }
            else if (!s_map.containsKey(c1) || !t_map.containsKey(c2)) {
                return false;
            }
            else if (s_map.get(c1) != c2 || t_map.get(c2) != c1) {
                return false;
            }
        }
        return true;
    }
}
