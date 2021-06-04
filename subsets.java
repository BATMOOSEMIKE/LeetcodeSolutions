//similar to solution for combinations
//note this solution can be optimized by backtracking, basically
//going down one path fully before recursing to minimize space usage

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> acc = new ArrayList<List<Integer>>();
        findSubsets(nums, 0, new ArrayList<Integer>(), acc);
        return acc;
    }

    public void findSubsets(int[] nums, int index, List<Integer> lacc, List<List<Integer>> acc){
        //if index >= nums.length then we have no more to add, so add lacc to acc
        if(index >= nums.length){
            acc.add(lacc);
        }
        //otherwise we either take nums[index] or don't
        else {
            List<Integer> lacc1 = new ArrayList<Integer>(lacc);
            lacc1.add(nums[index]);
            findSubsets(nums, index+1, lacc1, acc);
            findSubsets(nums, index+1, lacc, acc);
        }
        //if we don't, then keep going with index+1
        //if we do, add it to lacc and keep going with index+1
    }

    //for any element in nums, we can either include it or not include it
    //recursive
}
