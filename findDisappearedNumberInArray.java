//O(N) runtime, O(1) space, algorithm works by using input array
//as the data structure to track which digits appeared

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        //nums[i] will be 0 if i+1 has appeared in nums
        //we iterate through nums, from 0 to n-1
        //if nums[i] == 0 then do nothing, we have already visited here
        //if nums[i] == n, set nums[n-1] = 0 then continue with the number at nums[n-1]
        //until we get a 0

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int n = nums[i];
                while(n != 0){
                    int temp = nums[n-1];
                    nums[n-1] = 0;
                    n = temp;
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                result.add(i+1);
            }
        }

        return result;

    }
}
