class Solution {
    public int[] decompressRLElist(int[] nums) {
        int totalLength = 0;

        for(int i = 0; i < nums.length; i += 2) {
            totalLength += nums[i];
        }

        int[] result = new int[totalLength];
        int index = 0;

        for(int i = 0; i < nums.length; i+= 2) {
            int count = nums[i];
            for(int j = 0; j < count; j++){
                result[index] = nums[i+1];
                index++;
            }
        }

        return result;
    }
}
