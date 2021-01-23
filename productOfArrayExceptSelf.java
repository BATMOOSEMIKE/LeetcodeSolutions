class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean hasZero = false;

        int[] result = new int[nums.length];
        result[0] = 1;

        //populate result with product up to n
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int remainingProduct = 1;

        //now we update result with products excluding the number at that position
        //basically product up to n* product past n
        for(int i = nums.length-1; i >= 0; i--){
            result[i] = result[i] * remainingProduct;
            remainingProduct *= nums[i];
        }

        return result;
    }
}
