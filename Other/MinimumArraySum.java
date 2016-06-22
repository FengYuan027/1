/*
    Given Array A, B, sort B so that SUM(|A[i] - B[i]|) has the minimum value
*/

class Solution {
    public void reorderB(int[] A, int[] B) {
    		if (A.length != B.length || A.length <= 1) return;
    		int N = A.length;
    		int[] indice = new int[N];
    		for (int i = 0; i < N; i++) indice[i] = i;
    		mergeSortIndex(A, indice, 0, N - 1);
    		Arrays.sort(B);
    		int[] dummy = new int[N];
    		for (int i = 0; i < N; i++) dummy[indice[i]] = B[i];
    		for (int i = 0; i < N; i++) B[i] = dummy[i];
  	}
	
  	private void mergeSortIndex(int[] A, int[] indice, int start, int end) {
    		if (start >= end) return;
    		int mid = start + (end - start) / 2;
    		mergeSortIndex(A, indice, start, mid);
    		mergeSortIndex(A, indice, mid + 1, end);
    		int[] left = new int[mid - start + 1], right = new int[end - mid];
    		for (int i = 0; i < left.length; i++) left[i] = indice[start + i];
    		for (int i = 0; i < right.length; i++) right[i] = indice[mid + 1 + i];
    		for (int i = 0, j = 0, k = 0; k < end - start + 1; k++) {
      			if (i >= left.length) {
      				indice[start + k] = right[j++];
      			}
      			else if (j >= right.length) {
      				indice[start + k] = left[i++];
      			}
      			else {
      				indice[start + k] = A[indice[i]] <= A[indice[j]] ? left[i++] : right[k++];
      			}
    		}
  	}
}
