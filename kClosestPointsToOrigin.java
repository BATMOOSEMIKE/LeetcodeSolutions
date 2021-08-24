//O(NLogN) solution by sorting and iterating, can also be done with a heap but same speed

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (int[] point1, int[] point2) -> (point1[0]*point1[0] + point1[1]*point1[1]) - (point2[0]*point2[0] + point2[1]*point2[1]));

        int[][] ret = new int[k][2];

        for(int i = 0; i < k; i++){
            ret[i][0] = points[i][0];
            ret[i][1] = points[i][1];
        }

        return ret;
    }
}
