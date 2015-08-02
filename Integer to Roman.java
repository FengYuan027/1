public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        if (n <= 0 || n > 3999) return "";
        Hashtable<Integer, Character> map = new Hashtable<Integer, Character>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        int pivot = 1000;
        String roman = "";
        while (n > 0) {
            if (n / pivot > 0) {
                int digit = n / pivot;
                if (digit <= 3) {
                    roman = roman + map.get(pivot);
                    n -= pivot;
                }
                else if (digit == 4) {
                    roman = roman + map.get(pivot);
                    n += pivot;
                }
                else if (digit < 9) {
                    roman = roman + map.get(pivot*5);
                    n -= pivot*5;
                }
                else {
                    roman = roman + map.get(pivot);
                    n += pivot;
                    pivot *= 10;
                }
            }
            else pivot /= 10;
        }
        return roman;
    }
}
