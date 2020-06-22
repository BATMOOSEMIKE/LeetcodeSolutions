//This solution is for search insert, simpler/cleaner than mine.

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index =-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        return index==-1? nums.length: index;
    }
}
