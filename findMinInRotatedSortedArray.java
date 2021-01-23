class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[nums.length-1] > nums[0]){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;

        while(right > left+1){
            int mid = (left + right)/2;
            if(nums[mid] < nums[left]){
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return nums[right];
    }
}
