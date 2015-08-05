public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (count1 == 0 || num1 == num) {
                num1 = num;
                count1++;
            }
            else if (count2 == 0 || num2 == num) {
                num2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
                if (count1 == 0) {
                    count1++;
                    num1 = num;
                }
                else if (count2 == 0) {
                    count2++;
                    num2 = num;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == num1) count1++;
            if (nums.get(i) == num2) count2++;
        }
        return count1 > count2 ? num1 : num2;
    }
}
