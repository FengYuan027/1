public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (A == null) {
            return results;
        }
        Arrays.sort(A);
        for (Integer i : queries) {
            results.add(binarySearch(A, i) + 1);
        }
        return results;
    }
    
    public int binarySearch(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] >= target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
    }
}
