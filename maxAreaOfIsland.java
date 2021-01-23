class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        //row #
        for(int i = 0; i < grid.length; i++){
            //col #
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int size = countThenDestroy(grid, i, j);
                    if(size > max){
                        max = size;
                    }
                }
            }
        }

        return max;
    }

    //This is equivalent to DFS (recursive traversal of graph of nodes representing islands)
    public int countThenDestroy(int[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + countThenDestroy(grid, i-1,j) + countThenDestroy(grid, i+1,j) + countThenDestroy(grid, i, j-1) + countThenDestroy(grid, i, j+1);
        }
        return 0;
    }
}
