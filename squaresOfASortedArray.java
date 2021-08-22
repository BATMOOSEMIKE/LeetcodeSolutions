class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        //index in the new array
        int index = 0;

        //go to the transition point between negative and positive in nums, and expand outwards
        int positiveIncrement = 0;
        int negativeIncrement = 1;

        int checking = 0;
        //init checking
        while(checking < nums.length && nums[checking] < 0){
            checking++;
        }
        while(index < nums.length){
            //can only go left
            if(!(checking+positiveIncrement < nums.length)){
                res[index] = nums[checking-negativeIncrement] * nums[checking-negativeIncrement];
                negativeIncrement++;
            }
            //can only go right
            else if(!(checking-negativeIncrement >= 0)){
                res[index] = nums[checking+positiveIncrement] * nums[checking+positiveIncrement];
                positiveIncrement++;
            }
            //right is smaller
            else if(nums[checking+positiveIncrement] < -1*nums[checking-negativeIncrement]){
                res[index] = nums[checking+positiveIncrement] * nums[checking+positiveIncrement];
                positiveIncrement++;
            }
            //left is bigger
            else {
                res[index] = nums[checking-negativeIncrement] * nums[checking-negativeIncrement];
                negativeIncrement++;
            }
            index++;
        }

        return res;
    }
}
