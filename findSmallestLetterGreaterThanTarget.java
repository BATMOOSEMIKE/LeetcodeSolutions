//O(logN) time, binary search solution

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while(end >= start){
            int mid = (start + end)/2;
            if(mid == 0){
                return letters[0];
            }
            else if(letters[mid] > target && letters[mid-1] <= target){
                return letters[mid];
            }
            else if(letters[mid] > target){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }

        return letters[0];
    }
}
