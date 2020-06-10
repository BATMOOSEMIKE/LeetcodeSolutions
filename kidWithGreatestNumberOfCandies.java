class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int max = 0;
        for(int i = 0; i < candies.length; i++){
            if(candies[i] >= max) {
                max = candies[i];
            }
        }
        for(int j = 0; j < candies.length; j++){
            answer.add(candies[j]>=max-extraCandies);
        }
        return answer;
    }
}
