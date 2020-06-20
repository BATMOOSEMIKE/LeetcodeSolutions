class Solution {
    public int subtractProductAndSum(int n) {
        int digitSum = 0;
        int digitProduct = 1;

        while(n > 0){
            int currentDigit = n % 10;
            digitSum += currentDigit;
            digitProduct *= currentDigit;
            n /= 10;
        }

        return digitProduct - digitSum;
    }
}
