/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        if (A == null) return null;
        SegmentTreeNode root = build(A, 0, A.length - 1);
        ArrayList<Long> result = new ArrayList<Long>();
        for (Interval query: queries) {
            result.add(querySum(root, query.start, query.end));
        }
        return result;
    }
    
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (A == null || start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = (long)A[start];
        }
        else {
            root.left = build(A, start, (start + end)/2);
            root.right = build(A, (start + end)/2 + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }
    
    public long querySum(SegmentTreeNode root, int start, int end) {
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        long left_sum = 0, right_sum = 0;
        int mid = (start + end) / 2;
        if (start <= mid) {
            left_sum = querySum(root.left, start, Math.min(end, mid));
        }
        if (end > mid) {
            right_sum = querySum(root.right, Math.max(mid + 1, start), end);
        }
        return left_sum + right_sum;
    }
    
    public class SegmentTreeNode {
        int start, end;
        long sum;
        SegmentTreeNode left, right;
        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            sum = 0;
        }
    }
}
