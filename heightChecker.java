//O(NLogN) where N is length of heights
class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != sortedHeights[i]){
                count++;
            }
        }
        return count;
    }
}
