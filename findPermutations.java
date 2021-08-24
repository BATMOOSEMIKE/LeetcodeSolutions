class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<Integer>();

        for(int i: nums){
            numsList.add(i);
        }

        findPermutations(numsList, new ArrayList<Integer>());
        return res;
    }

    public void findPermutations(List<Integer> nums, List<Integer> acc){
        if(nums.size() == 0){
            res.add(acc);
        }
        else{
            for(int i = 0; i < nums.size(); i++){
                ArrayList<Integer> newAcc = new ArrayList<Integer>(acc);
                ArrayList<Integer> newNums = new ArrayList<Integer>(nums);
                newAcc.add(nums.get(i));
                newNums.remove(i);
                findPermutations(newNums, newAcc);
            }
        }
    }
}
