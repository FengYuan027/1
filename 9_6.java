public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int curr = nums.get(0), count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == curr) {
                count++;
            }
            else {
                count--;
                if (count == 0) {
                    curr = nums.get(i);
                    count = 1;
                }
            }
        }
        return curr;
    }
}

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

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() == 0 || k <= 0) {
            return 0;
        }
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        int index = 0;
        while (index < nums.size() && map.size() < k) {
            int num = nums.get(index++);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        
        while (index < nums.size()) {
            int num = nums.get(index++);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                if (map.containsValue(0)) {
                    map.put(num, 1);
                    for (Integer key: map.keySet()) {
                        if (map.get(key) == 0) {
                            map.remove(key);
                            break;
                        }
                    }
                }
                else {
                    for (Integer key: map.keySet()) {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }
        }
        
        int maj = 0, max_count = 0;
        for (Integer key: map.keySet()) {
            if (map.get(key) > max_count) {
                maj = key;
                max_count = map.get(key);
            }
        }
        return maj;
    }
}

