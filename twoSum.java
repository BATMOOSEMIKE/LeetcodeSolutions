class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] answers = new int[2];

        for(int i = 0; i<nums.length-1 ; i++){
            for(int j = 1; j<nums.length; j++){
                if(i!=j && nums[i]+nums[j]==target){
                    answers[0] = i;
                    answers[1] = j;
                    return answers;
                }
            }
        }

    return answers;

    }


}
