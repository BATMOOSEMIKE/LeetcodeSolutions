class Solution {
    public boolean canJump(int[] nums) {
        int lowestPossible = nums.length;
        //iterate backwards
        for(int i = nums.length-1; i >= 0; i--){
            int jumpAmount = nums[i];
            if(i + jumpAmount >= nums.length-1 || i + jumpAmount >= lowestPossible){
                lowestPossible = i;
            }
        }

        if(lowestPossible == 0){
            return true;
        }
        return false;
    }
}
