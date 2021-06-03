//This solution isn't great, I think it is O(N^2) runtime even after memoization
//because the for loop will run once for each possible start point
//There is a very cool linear runtime solution based on keeping track
//of previous max profit if u buy, previous max profit if u sell for 1-2 days before

class Solution {
    public int maxProfit(int[] prices) {
        List<Integer> memo = new ArrayList<Integer>();
        for(int i = 0; i < prices.length; i++){
            memo.add(-1);
        }
        return maxHelper(prices, memo, 0);
    }

    public int maxHelper(int[] prices, List<Integer> memo, int index){
        if(index >= prices.length){
            return 0;
        }
        else if(memo.get(index) != -1){
            return memo.get(index);
        }
        else {
            //first assume we buy today
            int maxProfit = 0;
            for(int i = index+1; i < prices.length; i++){
                if(prices[i] > prices[index]){
                    //see what's better, selling or no
                    maxProfit = Math.max(maxProfit, maxHelper(prices, memo, i+2)  + prices[i]-prices[index]);
                }
            }

            //now what if we don't buy today
            maxProfit = Math.max(maxProfit, maxHelper(prices, memo, index+1));

            memo.set(index, maxProfit);
            return maxProfit;
        }
    }
}
