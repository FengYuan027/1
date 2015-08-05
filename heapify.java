public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        int N = A.length;
        for (int i = N / 2; i >= 0; i--) {
            heapify(A, i, N);
        }
    }
    
    public void heapify(int[] A, int index, int N) {
        int target = index;
        if (2*index + 1 < N && A[2*index + 1] < A[target]) {
            target = 2 * index + 1;
        }
        if (2*index + 2 < N && A[2*index + 2] < A[target]) {
            target = 2 * index + 2;
        }
        if (target != index) {
            swap(A, target, index);
            heapify(A, target, N);
        }
    }
    
    public void swap(int[] A, int l, int r) {
        int t = A[l];
        A[l] = A[r];
        A[r] = t;
    }
}
