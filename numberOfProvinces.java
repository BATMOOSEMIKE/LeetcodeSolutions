class Solution {
    public int findCircleNum(int[][] isConnected) {
        //num of cities
        int n = isConnected.length;
        //0 indicates untouched, -1 indicates "follower", 1 indicates province leader
        int[] status = new int[n];

        for(int i = 0; i < n; i++){
            //if the current city has not yet been visited
            if(status[i] == 0){
                status[i] = 1;
                convert(isConnected, status, i);
            }
        }

        //count all province leaders
        int count = 0;
        for(int i = 0; i < n; i++){
            if(status[i] == 1){
                count++;
            }
        }

        return count;
    }

    public void convert(int[][] grid, int[] status, int i){
        //go through all other cities to see if it's connected
        for(int j = 0; j < grid.length; j++){
            //convert the right ones to followers
            if(j != i && status[j] == 0 && grid[i][j] == 1){
                status[j] = -1;
                convert(grid, status, j);
            }
        }
    }
}
