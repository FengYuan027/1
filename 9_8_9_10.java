
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char [] rotateString(char [] A, int offset) {
        // wirte your code here
        int len = A.length;
        if (len == 0) {
            return A;
        }
        offset %= len;
        reverse(A, 0, len - 1 - offset);
        reverse(A, len - offset, len - 1);
        reverse(A, 0, len - 1);
        return A;
    }
    
    public void reverse(char[] A, int start, int end) {
        while (start < end) {
            swap(A, start++, end--);
        }
    }
    
    public void swap(char[] A, int a, int b) {
        char temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            String temp = new String(strs[j]);
            strs[j] = new String(strs[i]);
            strs[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() > 0) {
                sb.append(strs[i]);
                if (i < strs.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        // three steps rotation
        int index = -1;
        int size = nums.size();
        if (size == 0) {
            return;
        }
        for (int i = 1; i < size; i++) {
            if (nums.get(i) <  nums.get(i - 1)) {
                index = i - 1;
                break;
            }
        }
        
        if (index == -1) {
            return;
        }
        
        reverse(nums, 0, index);
        reverse(nums, index + 1, size -1);
        reverse(nums, 0, size - 1);
        
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    public void swap(ArrayList<Integer> nums, int a, int b) {
        int temp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, temp);
    }
}

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                int j = nums.length - 1; 
                for(;j > i; j--){
                    if(nums[i] < nums[j]){
                        break;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                reverse(nums, i+1, nums.length-1);
                return nums;
            }
        }
        Arrays.sort(nums);
        return nums;
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

public class Solution {
   public int myAtoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
            
        int sign = 1;
        int index = 0;
    
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE ) {
                break;
            }
        }   
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m-1, j = n-1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}

public class Solution {
    public boolean search(int[] A, int target) {
        return searchRecur(A,target,0,A.length-1);
    }
    
    public boolean searchRecur(int[] A, int target, int start, int end){
        if (start>end) return false;
        
        int mid = (start+end)/2;
        if (A[mid]==target) return true;
        
        if (A[start]==A[mid] && A[end]==A[mid])
            return ( searchRecur(A,target,start,mid-1) || searchRecur(A,target,mid+1,end) );
        
        if (target>A[mid])
            if (A[start]>A[mid] && target>=A[start]) 
                return searchRecur(A,target,start,mid-1);
            else return searchRecur(A,target,mid+1,end);
        else 
            if (A[end]<A[mid] && target<=A[end])
                return searchRecur(A,target,mid+1,end);
            else return searchRecur(A,target,start,mid-1);
        
    }
        
        
}

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return -1;
        }
        
        int start = 0;
        int end = len - 1;
        
        // terminate condition: start and end wont overlapping.
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
            
            // if left half is sorted:
            if (A[mid] > A[start]) {
                if (target < A[mid] && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // right half is sorted
                if (target > A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int start = -1, end = -1;
        int p1 = 0, p2 = A.size()-1;
        //find start point.
        while (p1<=p2){
            int mid = (p1+p2)/2;
            
            if (A.get(mid)==target){
                if (mid==0 || A.get(mid-1)!=target){
                    start = mid;
                    break;
                } else {
                    p2 = mid-1;
                }
            } else if (A.get(mid)>target)
                p2 = mid-1;
            else p1 = mid+1;
        }
        
        //find end point.
        p1 = 0;
        p2 = A.size()-1;
        while (p1<=p2){
            int mid = (p1+p2)/2;
            
            if (A.get(mid)==target){
                if (mid==A.size()-1 || A.get(mid+1)!=target){
                    end = mid;
                    break;
                } else p1 = mid+1;
            } else if (A.get(mid)>target)
                p2 = mid-1;
            else p1 = mid+1;
        }
        
        res.add(start);
        res.add(end);
        
        return res;
    }
}
