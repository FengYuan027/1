public class Solution {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for(int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int elem : nums) {
            if (count1 == 0) {
                candidate1 = elem;
            }
            if (count2 == 0 && elem != candidate1) {
                candidate2 = elem;
            }
            if (candidate1 == elem) {
                count1++;
            }
            if (candidate2 == elem) {
                count2++;
            }
            if (candidate1 != elem && candidate2 != elem) {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int elem : nums) {
            if (elem == candidate1) count1++;
            else if (elem == candidate2) count2++;
        }
        return count1>count2? candidate1 : candidate2;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        int len  = nums.length;
        if (len%2 == 0) return search(nums, len/2, 0, len-1);
        else return search(nums, len/2+1, 0, len-1);
    }
    
    public int search(int[] nums, int k, int start, int end) {
        int l=start, r=end;
        int pivot = r;
        while (true) {
            while (nums[l] < nums[pivot] && l<r) {
                l++;
            }
            while (nums[r] >= nums[pivot] && l<r) {
                r--;
            }
            if (l == r) break;
            swap(nums, l, r);
        }
        swap(nums, l, end);
        if (k == l+1) return nums[l];
        else if (k > l+1) return search(nums, k, l+1, end);
        else return search(nums, k, start, l-1);
    }
    
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
