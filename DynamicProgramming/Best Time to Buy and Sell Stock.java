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

// III
public class SolutionIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}

// IV
public class SolutionIV1 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) profit += Math.max(0, prices[i] - prices[i-1]);
            return profit;
        }
        int[][] profit = new int[k+1][prices.length];
        for (int i = 1; i <= k; i++) {
            int maxAfterBuy = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j-1], maxAfterBuy + prices[j]);
                maxAfterBuy = Math.max(maxAfterBuy, profit[i-1][j-1] - prices[j]);
            }
        }
        return profit[k][prices.length-1];
    }
}

public class SolutionIV2 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) profit += Math.max(0, prices[i] - prices[i-1]);
            return profit;
        }
        int[] sell = new int[k+1], buy = new int[k+1];
        for (int i = 0; i <= k; i++) buy[i] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                if (prices[i] + buy[j] > sell[j]) {
                    sell[j] = prices[i] + buy[j];
                }
                if (sell[j-1] - prices[i] > buy[j]) {
                    buy[j] = sell[j-1] - prices[i];
                }
            }
        }
        return sell[k];
    }
}

// With Cooldown
public class CooDwonSolution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0, rest = 0;
        for (int price : prices) {
            int previousBuy = buy;
            buy = Math.max(buy, rest - price);
            rest = sell;
            sell = Math.max(sell, previousBuy + price);
        }
        return sell;
    }
}
