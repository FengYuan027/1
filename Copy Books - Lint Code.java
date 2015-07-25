public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null) return 0;
        if (k >= pages.length) {
            int max_page = 0;
            for (int i = 0; i < pages.length; i++) {
                max_page = Math.max(max_page, pages[i]);
            }
            return max_page;
        }
        int total = 0;
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
        }
        int average = total / k;
        return findMin(pages, k, average, total);
    }
    
    public int findMin(int[] pages, int k , int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (valid(pages, k, mid)) {
                high = mid;
            }
            else low = mid + 1;
        }
        return high;
    }
    
    public boolean valid(int[] pages, int k, int bound) {
        int people = 0, sum = 0;
        for (int i = 0; i < pages.length; i++) {
            if (sum + pages[i] > bound) {
                sum = 0;
                people++;
            }
            sum += pages[i];
        }
        return people < k && sum <= bound;
    }
}

