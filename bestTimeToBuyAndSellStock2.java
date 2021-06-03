//Linear time by just considering each increment, if it goes up buy at start of increment and
//sell at end of increment

class Solution {
    public int maxProfit(int[] prices) {
        int profitCount = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                profitCount += prices[i] - prices[i-1];
            }
        }

        return profitCount;
    }
}
