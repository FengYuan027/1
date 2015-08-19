public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a == null || b == null) {
            return "";
        }
        if (a.equals("") || b.equals("")) {
            return a.equals("") ? new String(b) : new String(a);
        }
        int indexA = a.length() - 1, indexB = b.length() - 1, carry = 0;
        String addition = "";
        while ((indexA >= 0 && indexB >= 0) || carry > 0) {
            int l = indexA >= 0 && a.charAt(indexA--) == '1' ? 1 : 0;
            int r = indexB >= 0 && b.charAt(indexB--) == '1' ? 1 : 0;
            int sum = l + r + carry;
            if (sum == 1 || sum == 3) {
                addition = '1' + addition;
            }
            else {
                addition = '0' + addition;
            }
            if (sum >= 2) {
                carry = 1;
            }
            else {
                carry = 0;
            }
        }
        if (indexA >= 0) {
            addition = a.substring(0, indexA + 1) + addition;
        }
        else if (indexB >= 0) {
            addition = b.substring(0, indexB + 1) + addition;
        }
        return addition;
    }
}
