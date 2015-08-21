public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return "";
        }
        Integer[] _num = new Integer[num.length];
        for (int i = 0; i < num.length; i++) {
            _num[i] = Integer.valueOf(num[i]);
        }
        Arrays.sort(_num, new SpecialComparator());
        if (_num[0] == 0) {
            return "0";
        }
        String result = "";
        for (Integer i: _num) {
            result += String.valueOf(i);
        }
        return result;
    }
    
    public class SpecialComparator implements Comparator<Integer> {
        public int compare(Integer v1, Integer v2) {
            String s1 = String.valueOf(v1) + String.valueOf(v2);
            String s2 = String.valueOf(v2) + String.valueOf(v1);
            int result = s1.compareTo(s2);
            if (result > 0) {
                return -1;
            }
            else if (result < 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}
