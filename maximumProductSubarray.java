class Solution {
    public int maxProduct(int[] nums) {
        //start at left
        //keep track of greatest product
        //keep track of current lowest product (most negative)
        //keep track of current greatest product (most positive)
        int greatest = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];

        for(int i = 1; i < nums.length; i++){

            int prevMax = curMax;

            //update curmax
            if(nums[i] > nums[i] * curMax){
                curMax = nums[i];
            }
            else {
                curMax = nums[i] * curMax;
            }

            //if curmin * num > curMax then update curmax again
            if(nums[i] * curMin > curMax){
                curMax = nums[i]*curMin;
            }

            //update curmin
            if(nums[i] < nums[i] * curMin){
                curMin = nums[i];
            }
            else {
                curMin = nums[i] * curMin;
            }

            //if curmax * num < curmin then update curmin again
            if(nums[i] * prevMax < curMin){
                curMin = nums[i] * prevMax;
            }

            if(curMax > greatest){
                greatest = curMax;
            }

        }

        return greatest;
    }
}
