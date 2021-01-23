class Solution {
    public int search(int[] nums, int target) {
        //first find pivot (log n time)
        //then if number is smaller than nums[0] search from pivot to end
        //else search from 0 to pivot
        //log(n) + log(n) is log(n)
        int pivot = pivot(nums);


        if(target < nums[0]){
            return binarySearch(nums, target, pivot, nums.length-1);
        }
        return binarySearch(nums, target, 0, pivot-1);
    }

    public int binarySearch(int[] nums, int target, int start, int end){
        //binary search from start to end (inclusive)
        int left = start;
        int right = end;

        while(right >= left){
            int mid = (right + left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        return -1;
    }

    public int pivot(int[] nums){
        int left = 0;
        int right = nums.length-1;
        if(right == 0){
            return nums.length;
        }
        else if(nums[right] > nums[left]){
            return nums.length;
        }

        while(right > left){
            int mid = (right+left+1)/2;

            if(mid != 0 && nums[mid] < nums[mid-1]){
                return mid;
            }
            else if(nums[mid] > nums[left]){
                left = mid;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}
