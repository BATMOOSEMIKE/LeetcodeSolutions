class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        else if(nums.length == 3){
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        return Math.max(robRange(nums, 0, nums.length-2), robRange(nums, 1, nums.length-1));
    }

    //nums has length at least 4
    public int robRange(int[] nums, int start, int end){
        int[] max = new int[nums.length];
        max[start] = nums[start];
        max[start+1] = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i <= end; i++){
            max[i] = Math.max(nums[i] + max[i-2], max[i-1]);
        }

        return max[end];
    }
}
