public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n <= 0) return false;
        boolean[] map = new boolean[5];
        map[0] = true;
        map[1] = true;
        map[2] = false;
        map[3] = true;
        if (n <= 4) {
            return map[n - 1];
        }
        while (n > 4) {
            if (map[2] && map[1] || map[1] && map[0]) {
                map[4] = true;
            }
            else map[4] = false;
            map[0] = map[1];
            map[1] = map[2];
            map[2] = map[3];
            map[3] = map[4];
            n--;
        }
        
        return map[3];
    }
}
