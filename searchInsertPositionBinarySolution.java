//This is just binary search. Faster runtime (Log N vs N) compared to linear scan
//but takes more lines of code

public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int middle = left + (right - left) / 2;

            if(nums[middle] == target){
                return middle;
            }

            if(nums[middle] < target){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }

        }

        return left;
    }
