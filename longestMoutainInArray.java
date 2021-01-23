class Solution {
    enum Status {
        climbing,
        falling,
        start
    }
    public int longestMountain(int[] arr) {
        Status status = Status.start;

        int prev = arr[0];
        int longest = 0;
        int curCount = 1;

        for(int i = 1; i < arr.length; i++){
            if(status == Status.start){
                if(arr[i] > prev){
                    status = Status.climbing;
                    curCount++;
                }
                prev = arr[i];
            }
            else if(status == Status.climbing){
                //keep climbing
                if(arr[i] > prev){
                    curCount++;
                }
                //we were not on a mountain, reset all
                else if(arr[i] == prev){
                    status = Status.start;
                    curCount = 1;
                }
                //now we are falling
                else{
                    status = Status.falling;
                    curCount++;
                }
            }
            else {
                //end of mountain, flat
                if(arr[i] == prev){
                    status = Status.start;
                    if(curCount > longest){
                        longest = curCount;
                    }
                    curCount = 1;
                }
                //turns out we actually started the next mountain
                else if(arr[i] > prev){
                    status = Status.climbing;
                    if(curCount > longest){
                        longest = curCount;
                    }
                    curCount = 2;
                }
                //keep falling
                else {
                    curCount++;
                }
            }
            prev = arr[i];
        }

        if(status == Status.falling){
            return Math.max(curCount, longest);
        }
        return longest;
    }
}
