// I:
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0, min_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min_price);
            min_price = Math.min(min_price, prices[i]);
        }
        return profit;
    }
}

// II:
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
    
// III:
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sell1 = 0, sell2 = 0;
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            sell2 = Math.max(sell2, hold2 + prices[i]);
            hold2 = Math.max(hold2, sell1 - prices[i]);
            sell1 = Math.max(sell1, hold1 + prices[i]);
            hold1 = Math.max(hold1, 0 - prices[i]);
        }
        return sell2;
    }
};


// IV:
class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2 || k <= 0) {
            return 0;
        }
        int N = prices.length;
        if (k > N/2) {
            int profit = 0;
            for (int i = 1; i < N; i++) {
                if (prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }
        int[] sells = new int[k+1];
        int[] holds = new int[k+1];
        Arrays.fill(holds, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            for (int j = k; j > 0; j--) {
                sells[j] = Math.max(sells[j], holds[j] + prices[i]);
                holds[j] = Math.max(holds[j], sells[j-1] - prices[i]);
            }
        }
        return sells[k];
    }
};
