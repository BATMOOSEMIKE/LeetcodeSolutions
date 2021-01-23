class Solution {
    public int maxArea(int[] height) {

        int leftIndex = 0;
        int rightIndex = height.length-1;
        int width = height.length-1;
        int maxArea = computeArea(leftIndex, rightIndex, width, height);

        while (rightIndex > leftIndex){

            int newArea;
            width--;
            //left taller than right, shift right one in
            if(height[leftIndex] > height[rightIndex]){
                rightIndex--;
                newArea = computeArea(leftIndex, rightIndex, width, height);
            }
            else {
                leftIndex++;
                newArea = computeArea(leftIndex, rightIndex, width, height);
            }
            maxArea = Math.max(newArea, maxArea);
        }

        return maxArea;
    }

    public int computeArea(int left, int right, int width, int[] height){
        return Math.min(height[left], height[right]) * width;
    }
}
