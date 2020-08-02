//O(NLogN) where N is the length of nums.
//O(N) solution is possible but this is the simplest.
class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return((nums[nums.length-1] - 1) * (nums[nums.length-2] - 1));
    }
}
