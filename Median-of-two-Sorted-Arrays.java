class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        int total_length = A.length + B.length;
        if (total_length%2 == 1) {
            return findKthElement(A, B, total_length/2 + 1, 0, A.length - 1, 0, B.length - 1)*1.0;
        }
        else {
            return (findKthElement(A, B, total_length/2, 0, A.length - 1, 0, B.length - 1) + findKthElement(A, B, total_length/2 + 1, 0, A.length - 1, 0, B.length - 1))/2.0;
        }
    }
    
    public int findKthElement(int[] A, int[] B, int k, int m, int n, int p, int q) {
        if (m > n) return B[k-1+p];
        if (p > q) return A[k-1+m];
        if (k == 1) return Math.min(A[m], B[p]);
        int mid1 = (m + n) / 2;
        int mid2 = (p + q) / 2;
        if (A[mid1] <= B[mid2]) {
            if (mid1 - m + mid2 - p + 1 >= k) return findKthElement(A, B, k, m, n, p, mid2 - 1);
            else return findKthElement(A, B, k - mid1 + m - 1, mid1 + 1, n, p, q);
        }
        else {
            if (mid1 - m + mid2 - p + 1 >= k) return findKthElement(A, B, k, m, mid1 - 1, p, q);
            else return findKthElement(A, B, k - mid2 + p - 1, m, n, mid2 + 1, q);
        }
    }
}
