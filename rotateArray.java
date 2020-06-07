class Solution {
    /*
    public void rotate(int[] nums, int k) {

        if(nums.length == 0){
            return;
        }

        for(int i = 0; i < k; i++){

            int lastone = nums[0];

            for(int j = 0; j < nums.length; j++){
                if(j != nums.length-1){
                    int temp = nums[j+1];
                    nums[j+1] = lastone;
                    lastone = temp;
                }
                else{
                    int temp = nums[0];
                    nums[0] = lastone;
                    lastone = temp;
                }
            }
        }
    }
    */
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
