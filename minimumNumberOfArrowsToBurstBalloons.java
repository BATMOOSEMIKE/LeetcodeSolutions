//O(n) runtime with a greedy algorithm

class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort 2d array so that the intervals are in order by their start points

        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(final int[] row1, final int[] row2){
                if(row1[0] > row2[0]){
                    return 1;
                }
                else if(row1[0] == row2[0] && row1[1] > row2[1]){
                    return 1;
                }
                return -1;
            }
        });

//         for(int i = 0; i < points.length; i++){
//             System.out.println(points[i][0] + " " + points[i][1]);
//         }

        //for each interval, check how many additional intervals can be popped by the same arrow
        //increment by how many intervals we popped and add 1 to arrow count
        int arrowCount = 0;
        int index = 0;
        while(index < points.length){
            int start = points[index][0];
            int end = points[index][1];

            int secondIndex = index+1;
            while(secondIndex < points.length){
                int start2 = points[secondIndex][0];
                int end2 = points[secondIndex][1];

                if(start2 <= end){
                    end = Math.min(end, end2);
                }
                else{
                    break;
                }
                secondIndex++;
            }
            arrowCount++;
            index = secondIndex;
        }

        return arrowCount;



    }
}
