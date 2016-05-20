// I
public class Solution {
    public int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - currentMin);
            currentMin = Math.min(currentMin, prices[i]);
        }
        return maxProfit;
    }
}
