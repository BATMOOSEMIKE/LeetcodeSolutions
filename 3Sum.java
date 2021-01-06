//Runtime O(N^2) where N is the length of nums
//Sorts array to make skipping duplicates easier then iterates through
//the sorted array while running 2sum (using 2 pointers) on the rest of the array

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length){
            //First use pointer version of two sum on the rest of the array
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int curSum = nums[left] + nums[right] + nums[i];
                //if solution is found for a particular triplet
                if(curSum == 0){
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(nums[i]);
                    solution.add(nums[left]);
                    solution.add(nums[right]);
                    solutions.add(solution);
                    int prev = nums[left];
                    while(left < nums.length && nums[left] == prev){
                        left++;
                    }
                }
                else if(curSum < 0){
                    int prev = nums[left];
                    while(left < nums.length && nums[left] == prev){
                        left ++;
                    }
                }
                else {
                    int prev = nums[right];
                    while(right >= 0 && nums[right] == prev){
                        right--;
                    }
                }
            }
            int prev = nums[i];
            while(i < nums.length && nums[i] == prev){
                i++;
            }
        }

        return solutions;

    }
}
