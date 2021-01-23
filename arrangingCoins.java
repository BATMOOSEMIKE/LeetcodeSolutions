class Solution {
    public int arrangeCoins(int n) {
        //(i(i+1))/2 <= n
        double upperBound = Math.sqrt((double)n*2);
        double i = 0;
        while(i <= upperBound){
            if(i*(i+1)/2 > n){
                break;
            }
            i += 1;
        }
        return (int)i-1;
    }
}
