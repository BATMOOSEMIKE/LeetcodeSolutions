//O(1) runtime of sumRange with O(n) extra space
//by keeping track of sum up to each point

class NumArray {

    int[] storedNums;
    int[] storedSums;

    public NumArray(int[] nums) {
        storedNums = new int[nums.length];
        storedSums = new int[nums.length+1];
        int curSum = 0;
        storedNums[0] = 0;
        for(int i = 0; i < nums.length; i++){
            storedNums[i] = nums[i];
            curSum += nums[i];
            storedSums[i+1] = curSum;
        }
    }

    public int sumRange(int left, int right) {
        return storedSums[right+1]-storedSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
