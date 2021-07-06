//O(n) runtime with O(1) space using bit manipulation
//We are doing XOR of every number in nums, because XOR of two equal things is 0
//and XOR of 0 and any number b is b

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            a ^= nums[i];
        }
        return a;
    }
}
