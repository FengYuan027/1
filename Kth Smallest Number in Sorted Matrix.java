public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        int M = matrix.length, N = matrix[0].length;
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(M, new ElementComparator());
        for (int i = 0; i < M; i++) {
            minHeap.add(new Element(i, 0, matrix[i][0]));
        }
        int order = 0;
        Element number = null;
        while (order < k) {
            number = minHeap.poll();
            if (number.col < N - 1) {
                minHeap.add(new Element(number.row, number.col + 1, matrix[number.row][number.col+1]));
            }
            order++;
        }
        return number.val;
    }
    
    public class Element {
        int row, col, val;
        public Element(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }
    
    public class ElementComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            if (e1.val > e2.val) {
                return 1;
            }
            else if (e1.val < e2.val) {
                return -1;
            }
            else return 0;
        }
    }
}
