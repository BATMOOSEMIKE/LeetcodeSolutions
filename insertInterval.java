class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean added = false;


        for (int[] array: intervals) {
            if(newInterval[0] > array[1]) {
                result.add(array);
            } else if ( array[0] > newInterval[1]) {
                if(!added) {
                    added = true;
                    result.add(newInterval);
                }
                result.add(array);
            } else {
                newInterval[0] = Integer.min(newInterval[0], array[0]);
                newInterval[1] = Integer.max(newInterval[1], array[1]);
            }
        }
        if(!added){
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
