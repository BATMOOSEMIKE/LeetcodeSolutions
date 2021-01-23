class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];

        //basic heuristic is
        //if number is bigger than number + cursum, then cursum = number
        //otherwise add the number to cursum, and check if thats bigger than maxsum
        //update maxsum if needed
        for(int i = 1; i < nums.length; i++){
            if(nums[i] + curSum < nums[i]){
                curSum = nums[i];
            }
            else {
                curSum += nums[i];
            }

            if(curSum > maxSum){
                maxSum = curSum;
            }
        }

        return maxSum;
    }
}
