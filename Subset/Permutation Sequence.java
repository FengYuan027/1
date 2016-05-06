/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        if (k <= 0 || n <= 0) return "";
        int pivot = 1;
        char[] permutation = new char[n];
        for (int i = 1; i <= n; i++) {
            pivot *= i;
            permutation[i-1] = (char)(i + '0');
        }
        k = (k-1) % pivot;
        pivot /= n;
        for (int i = 0; i < n && k > 0; i++) {
            if (k / pivot > 0) {
                int offset = k / pivot;
                char target = permutation[i+offset];
                for (int j = i + offset; j > i; j--) {
                    permutation[j] = permutation[j-1];
                }
                permutation[i] = target;
                k -= offset * pivot;
            }
            pivot /= (n-i-1);
        }
        return new String(permutation);
    }
}
