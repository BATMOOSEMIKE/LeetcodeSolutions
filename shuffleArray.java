class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[2*n];
        for(int i = 0; i < 2*n; i++){
            //"even" index so odd number
            if(i % 2 == 0){
                answer[i] = nums[i/2];
            }
            // "odd" index so even number
            else {
                answer[i] = nums[i/2 + n];
            }
        }
        return answer;
    }
}
