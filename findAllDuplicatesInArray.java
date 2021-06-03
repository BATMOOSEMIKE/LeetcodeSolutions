//O(n) runtime and O(1) space, using nums as the array of counters

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();

        //iterate through i = 0 to nums.length -1
        //if nums[i] = -1 or -2 or 0, then we have already processed the number at i so do nothing
        //if nums[i] = n, process n, update nums[n-1] and take the number that was at nums[n-1]
        //for future processing
        //0 means 0 appearances but the number previously here was processed
        //-1 means 1 appearance
        //-2 means 2 appearances
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != -1 && nums[i] != -2 && nums[i] != 0){
                int n = nums[i];
                if(n != -1 && n != -2){
                    nums[i] = 0;
                }
                while(n != -1 && n != -2 && n != 0){
                    int temp = nums[n-1];
                    if(temp == -1){
                        nums[n-1] = -2;
                    }
                    else {
                        nums[n-1] = -1;
                    }
                    n = temp;
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == -2){
                duplicates.add(i+1);
            }
        }

        return duplicates;
    }
}
