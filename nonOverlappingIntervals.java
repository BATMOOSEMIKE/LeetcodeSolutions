class Solution {
    int removed = 0;

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[]b) -> a[0]-b[0]);

        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < prevEnd) {
                //remove previous
                if(prevEnd > intervals[i][1]){
                    prevEnd = intervals[i][1];
                }
                removed++;
            }
            //no removals, just update prev
            else {
                prevEnd = intervals[i][1];
            }
        }

        return removed;
    }

}
