class Solution {
    public int rob(int[] nums) {

        //heuristic idea
        //first start at right side of array
        //check how much is the max you can get if you were "starting" at that position

        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }

        int n = nums.length;
        int[] maxAmount = new int[n];

        maxAmount[n-1] = nums[n-1];
        maxAmount[n-2] = nums[n-2];
        maxAmount[n-3] = nums[n-3] + nums[n-1];

        for(int i = n-4; i >=0; i--){
            maxAmount[i] = nums[i] + Math.max(maxAmount[i+2], maxAmount[i+3]);
        }

        for(int i = 0; i < n; i++){
            System.out.println(maxAmount[i]);
        }

        return Math.max(maxAmount[0], maxAmount[1]);


    }


}
