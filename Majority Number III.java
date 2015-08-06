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
