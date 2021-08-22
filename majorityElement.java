//O(infinity), but on average O(n) runtime
//very fun solution with randomly choosing candidates
//optimal solution is boyer-moore, where we partition the array into sections
//basically removing minority/majority numbers equally until we reach the end
class Solution {
    public int majorityElement(int[] nums) {
        while(true){
            int candidate = nums[(int) (Math.random() * nums.length)];
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == candidate){
                    count++;
                }
                if(count > nums.length/2){
                    return candidate;
                }
            }
        }

    }
}
