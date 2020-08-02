//O(N) where N is the size of the grid

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] leftMax = new int[grid.length];
        int[] topMax = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++){
            int max = 0;
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            leftMax[i] = max;
        }

        for(int i = 0; i < grid[0].length; i++){
            int max = 0;
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] > max){
                    max = grid[j][i];
                }
            }
            topMax[i] = max;
        }

        int sum = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < Math.min(topMax[j], leftMax[i])) {
                    sum += Math.min(topMax[j], leftMax[i]) - grid[i][j];
                }
            }
        }


        return sum;

    }
}
