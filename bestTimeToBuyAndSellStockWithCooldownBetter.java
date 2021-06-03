//This solution is super cool, linear runtime

class Solution {
    public int maxProfit(int[] prices) {
        //max profit if the last action on day n was buying
        int[] lastWasBuy = new int[prices.length];
        //max profit if the last action on day n was selling
        int[] lastWasSell = new int[prices.length];
        //max profit up to day n-1
        int[] maxProfit = new int[prices.length];

        //if we buy on day 0 we are now at negative balance
        lastWasBuy[0] = -prices[0];

        for(int i = 1; i < prices.length; i++){
            //If selling on day i-1 generates more profit, then we update max profit
            maxProfit[i] = Math.max(lastWasSell[i-1], maxProfit[i-1]);
            //If buying today is good, then update
            lastWasBuy[i] = Math.max(lastWasBuy[i-1], maxProfit[i-1] - prices[i]);
            //If selling today is good, then update
            lastWasSell[i] = Math.max(lastWasBuy[i-1] + prices[i], lastWasSell[i-1]);
        }

        return lastWasSell[prices.length-1];
    }
}
