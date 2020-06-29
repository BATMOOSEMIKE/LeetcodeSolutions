class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(digitEven(nums[i])){
                count++;
            }
        }
        return count;
    }

    public boolean digitEven(int n) {
        int digitCount = 0;
        while(n > 0) {
            n /= 10;
            digitCount++;
        }
        return (digitCount%2==0);
    }
}
