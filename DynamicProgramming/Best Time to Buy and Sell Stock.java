// I
public class SolutionI {
    public int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - currentMin);
            currentMin = Math.min(currentMin, prices[i]);
        }
        return maxProfit;
    }
}

// II
public class SolutionII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i-1]);
        }
        return profit;
    }
}
