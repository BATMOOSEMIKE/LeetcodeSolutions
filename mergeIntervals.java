class Solution {
    public int[][] merge(int[][] intervals) {
        //sort intervals
        //iterate through and add intervals to a new arraylist
        //convert to array
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);

        ArrayList<Integer[]> mergedIntervals = new ArrayList<Integer[]>();
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] <= curEnd && intervals[i][1] > curEnd){
                curEnd = intervals[i][1];
            }
            //ignore this new interval
            else if(intervals[i][0] <= curEnd){

            }
            //start of a new interval
            else {
                Integer[] newInterval = new Integer[]{curStart, curEnd};
                mergedIntervals.add(newInterval);
                curStart = intervals[i][0];
                curEnd = intervals[i][1];
            }
        }
        Integer[] newInterval = new Integer[]{curStart, curEnd};
        mergedIntervals.add(newInterval);

        int[][] result = new int[mergedIntervals.size()][2];

        for(int i = 0; i < mergedIntervals.size(); i++){
            result[i][0] = mergedIntervals.get(i)[0];
            result[i][1] = mergedIntervals.get(i)[1];
        }

        return result;

    }
}
