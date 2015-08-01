public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, index = 0;
        while (index < s.length()) {
            if (index + 1 < s.length() && map.get(s.charAt(index)) < map.get(s.charAt(index+1))) {
                result += map.get(s.charAt(index+1)) - map.get(s.charAt(index));
                index += 2;
            }
            else {
                result += map.get(s.charAt(index));
                index ++;
            }
        }
        return result;
    }
}
