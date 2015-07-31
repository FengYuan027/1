public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean allowSpace = true;
        int index = s.length() - 1, start = 0, end = 0;
        while (index >= 0) {
            if (s.charAt(index) == ' ') {
                if (allowSpace) index--;
                else {
                    start = index+1;
                    break;
                }
            }
            else {
                if (allowSpace) {
                    allowSpace = false;
                    end = index;
                }
                index--;
            }
        }
        return end - start + 1;
    }
}
