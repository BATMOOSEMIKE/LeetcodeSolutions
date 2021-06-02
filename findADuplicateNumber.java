//This is the tortoise and hare algorithm
//O(N) runtime where n is length of nums, O(1) space
//same approach as detecting a cycle in a linked list

class Solution {
    public int findDuplicate(int[] nums) {
        //slow pointer
        int tortoise = 0;
        //fast pointer
        int hare = 0;

        //one jump for tortoise
        tortoise = nums[tortoise];
        //two jumps for hare
        hare = nums[nums[hare]];

        while(tortoise != hare){
            //one jump for tortoise
            tortoise = nums[tortoise];
            //two jumps for hare
            hare = nums[nums[hare]];
        }

        //now tortoise and hare are intersecting
        //move tortoise back to start and let him and hare continue 1 step at a time
        tortoise = 0;

        while(tortoise != hare){
            //one jump for tortoise
            tortoise = nums[tortoise];
            //one jump for hare
            hare = nums[hare];
        }

        return hare;

    }
}
