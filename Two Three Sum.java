public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target-numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[2];
    }
}


public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                if (numbers[i] + numbers[start] + numbers[end] == 0) {
                    ArrayList<Integer> set = new ArrayList<>();
                    set.add(numbers[i]);
                    set.add(numbers[start]);
                    set.add(numbers[end]);
                    ret.add(set);
                    start++;
                    end--;
                    while (start < end && numbers[start] == numbers[start-1]) {
                        start++;
                    }
                    while (end > start && numbers[end] == numbers[end+1]) {
                        end--;
                    }
                } else {
                    if (numbers[i] + numbers[start] + numbers[end] < 0)
                        start++;
                    else
                        end--;
                }
            }
            while (i + 1 < numbers.length && numbers[i+1] == numbers[i]) {
                i++;
            }
        }
        return ret;
    }
}

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] num ,int target) {
        // write your code here
        int closest = num[0] + num[1] + num[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    start++;
                else
                    end--;
            }
        }
        return closest;
    }
}
