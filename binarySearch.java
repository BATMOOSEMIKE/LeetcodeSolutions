//O(LogN) where N is the length of nums

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public int binarySearch(int[] arr, int target, int low, int high){
        if(high < low){
            return -1;
        }

        int mid = (low + high)/2;

        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] > target) {
            return binarySearch(arr, target, low, mid-1);
        }
        else{
            return binarySearch(arr, target, mid+1, high);
        }
    }
}
