public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int N = ratings.length;
        int[] candies = new int[N + 1];
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i-1]) candies[i] = candies[i-1] + 1;
        }
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) candies[i] = candies[i+1] + 1;
        }
        int sum = N;
        for (int i = 0; i < N; i++) sum += candies[i];
        return sum;
    }
}
