//O(N) runtime improved solution 

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowest = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lowest) {
                lowest = prices[i];
            }
            if(prices[i] - lowest > max){
                max = prices[i] - lowest;
            }
        }

        return max;
    }
}
