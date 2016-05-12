/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

public class Solution1 {
    public boolean wordPattern(String _pattern, String _str) {
        char[] pattern = _pattern.toCharArray();
        String[] str = _str.split(" ");
        if (pattern.length != str.length) return false;
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length; i++) {
            char c = pattern[i];
            String s = str[i];
            if (map1.containsKey(c) && map2.containsKey(s)) {
                if (!map1.get(c).equals(s) || !map2.get(s).equals(c)) {
                    return false;
                }
            }
            else if (map1.containsKey(c) || map2.containsKey(s)) {
                return false;
            }
            else {
                map1.put(c, s);
                map2.put(s, c);
            }
        }
        return true;
    }
}

public class Solution2 {
    public boolean wordPattern(String pattern, String _str) {
        String[] str = _str.split(" ");
        if (str.length != pattern.length()) return false;
        Map map = new HashMap<>();
        for (Integer i = 0; i < str.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(str[i], i)) {
                return false;
            }
        }
        return true;
    }
}
