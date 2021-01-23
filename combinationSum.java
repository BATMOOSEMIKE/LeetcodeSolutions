class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] answers = new int[target+1];
        answers[0] = 1;

        //answers[i] is how many ways there are to make i
        for(int i = 1; i <= target; i++){
            int count = 0;
            //iterate through all nums and check i - num
            for(int j = 0; j < nums.length; j++){
                int num = nums[j];
                if(i-num >= 0){
                    count += answers[i-num];
                }
            }
            answers[i] = count;
        }

        return answers[target];
    }
}
