class Solution {
    //Logic of my program is to take the sum of number and complement
    //and then subtract original num to find complement
    public int findComplement(int num) {
        int exp = customLog(num);
        if(exp < 31){
            return (int) (Math.pow(2,exp) - 1 - num);
        }
        return 2147483647-num;
    }

    public int customLog(int n){
        int count = 0;
        int curExponent = 0;

        while(Math.pow(2,curExponent) - 1 < n && curExponent < 31){
            curExponent++;
        }

        return curExponent;
    }
}
