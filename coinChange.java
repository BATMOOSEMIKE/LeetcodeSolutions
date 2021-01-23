class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int min = helper(amount, coins, new HashMap < Integer, Integer > ());
        return min;
    }

    public static int helper(int totalMoney, int[] coins, HashMap < Integer, Integer > minCounts) {
        if(totalMoney < 0){
            return -1;
        }
        else if (totalMoney == 0) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                int amountToCheck = totalMoney - coins[i];
                if (amountToCheck >= 0) {
                    int minNumTemp;
                    //if that amount has been previously encountered
                    if (minCounts.containsKey(amountToCheck)) {
                        minNumTemp = minCounts.get(amountToCheck);
                    }
                    //if not
                    else {
                        minNumTemp = helper(totalMoney - coins[i], coins, minCounts);
                    }
                    if (minNumTemp >= 0 && minNumTemp < min) {
                        min = minNumTemp;
                    }
                }
            }

            if(min == Integer.MAX_VALUE){
                minCounts.put(totalMoney, -1);
                return -1;
            }
            minCounts.put(totalMoney, 1 + min);
            return 1 + min;
        }
    }
}
