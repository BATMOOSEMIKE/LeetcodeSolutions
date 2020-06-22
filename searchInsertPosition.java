class Solution {
    public int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
            else if(i != 0 && nums[i-1] <= target && nums[i] >= target) {
                return i;
            }
            else if(i == 0 && nums[i] > target) {
                return i;
            }
        }

        return nums.length;
    }
}
