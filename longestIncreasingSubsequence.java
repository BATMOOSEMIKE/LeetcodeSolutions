class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] maxFromI = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--){
            int max = 1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    max = Math.max(max, maxFromI[j] + 1);
                }
            }
            maxFromI[i] = max;
            System.out.println(i + " " + max);
        }

        int newMax = maxFromI[0];
        for(int i = 0; i < maxFromI.length; i++){
            if(maxFromI[i] > newMax){
                newMax = maxFromI[i];
            }
        }

        return newMax;
    }
}
