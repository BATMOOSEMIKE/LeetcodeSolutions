//O(NLogN) where N is length of nums

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> subsequence = new ArrayList<Integer>();
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int newSum = 0;
        int i = nums.length-1;
        while(newSum <= sum/2) {
            newSum += nums[i];
            subsequence.add(nums[i]);
            i--;
        }
        return subsequence;

    }
}
