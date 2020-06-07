class Solution {
    public boolean containsDuplicate(int[] nums) {
        String[] numbers = new String[nums.length];

        for(int i = 0; i<nums.length;i++){
            numbers[i] = Integer.toString(nums[i]);
        }

        List<String> list = Arrays.asList(numbers);
        Set<String> set = new LinkedHashSet<String>(list);

        if(nums.length != set.size()){
            return true;
        }
        return false;
    }
}
