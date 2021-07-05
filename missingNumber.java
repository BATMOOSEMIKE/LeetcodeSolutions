//O(n) runtime, O(1) space by comparing actual vs expected sum

class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length*(nums.length+1)/2);
        int actSum = 0;
        for(int i = 0; i < nums.length; i++){
            actSum += nums[i];
        }
        return sum-actSum;
    }
}
